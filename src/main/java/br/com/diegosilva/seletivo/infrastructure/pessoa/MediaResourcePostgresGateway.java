package br.com.diegosilva.seletivo.infrastructure.pessoa;

import br.com.diegosilva.seletivo.domain.pessoa.MediaResourceGateway;
import br.com.diegosilva.seletivo.domain.pessoa.PessoaFoto;
import br.com.diegosilva.seletivo.domain.pessoa.PessoaId;
import br.com.diegosilva.seletivo.domain.shared.Resource;
import br.com.diegosilva.seletivo.infrastructure.config.properties.StorageProperties;
import br.com.diegosilva.seletivo.infrastructure.service.StorageService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MediaResourcePostgresGateway implements MediaResourceGateway {

    private final StorageService storageService;

    private final String locationPattern;

    public MediaResourcePostgresGateway(StorageService storageService, final StorageProperties props) {
        this.storageService = storageService;
        this.locationPattern = props.getLocationPattern();
    }

    @Override
    public PessoaFoto storeImage(PessoaId anId, Resource aResource) {
        String filepath = folder(anId).concat("/").concat(aResource.name());

        storageService.store(filepath,aResource);

        return new PessoaFoto(
                null, LocalDate.now(),filepath,  aResource.checksum()
        );
    }

    @Override
    public String generateTemporaryLink(String id) {
        return storageService.generateTemporaryLink(id);
    }

    @Override
    public void clearResources(PessoaId pessoaId) {
        final var ids = this.storageService.list(folder(pessoaId));
        this.storageService.deleteAll(ids);
    }

    private String folder(final PessoaId anId) {
        return locationPattern.replace("{pessoaId}", anId.value().toString());
    }

    private String filepath(final PessoaId anId) {
        return folder(anId)
                .concat("/");
    }
}
