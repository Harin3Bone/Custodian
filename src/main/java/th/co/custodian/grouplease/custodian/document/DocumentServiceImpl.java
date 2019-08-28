package th.co.custodian.grouplease.custodian.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import th.co.custodian.grouplease.custodian.contact.ContactRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    public DocumentServiceImpl(DocumentRepository theDocumentRepository){
        documentRepository = theDocumentRepository;
    }

    @Override
    @Transactional
    public List<DocumentEntity> getDocumentAll() {
        return documentRepository.findAll();
    }

    @Override
    @Transactional
    public DocumentEntity getDocumentById(long documentId) {
        Optional<DocumentEntity> result = documentRepository.findById(documentId);
        DocumentEntity documentEntity = null;
        if (result.isPresent()){
            documentEntity = result.get();
        }
        else {
            throw new RuntimeException("Did not find document by id "+documentId);
        }
        return documentEntity;
    }

    @Override
    @Transactional
    public void createDocument(DocumentEntity documentEntity) {
        documentRepository.save(documentEntity);
    }
}
