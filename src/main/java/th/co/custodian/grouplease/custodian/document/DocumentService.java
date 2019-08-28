package th.co.custodian.grouplease.custodian.document;

import java.util.List;

public interface DocumentService {
    public List<DocumentEntity> getDocumentAll();
    public DocumentEntity getDocumentById(long documentId);
    public void createDocument(DocumentEntity documentEntity);
}
