package ma.xproce.computerservice.web;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ComputerGraphQLController {

    private final GraphQL graphQL;

    @Autowired
    public ComputerGraphQLController(GraphQL graphQL) {
        this.graphQL = graphQL;
    }

    @PostMapping("/graphql")
    public ResponseEntity<Object> executeQuery(@RequestBody Map<String, String> query) {
        return executeGraphQLQuery(query.get("query"));
    }

    private ResponseEntity<Object> executeGraphQLQuery(String query) {
        try {
            Map<String, Object> result = graphQL.execute(query).toSpecification();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
