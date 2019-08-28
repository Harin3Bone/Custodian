package th.co.custodian.grouplease.custodian.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/document")
public class DocumentController {
    private DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService theDocumentService){
        documentService = theDocumentService;
    }

    @GetMapping()
    public List<DocumentEntity> getAllDocument(){
        return documentService.getDocumentAll();
    }

    @GetMapping(path = "/{documentId}")
    public DocumentEntity getDocumentById(@PathVariable long documentId){
        return documentService.getDocumentById(documentId);
    }

    @PostMapping()
    public DocumentEntity createDocument(@RequestBody DocumentEntity documentEntity){
        documentService.createDocument(documentEntity);
        return documentEntity;
    }
}
