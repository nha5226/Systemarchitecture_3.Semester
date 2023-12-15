package writeside;

import writeside.application.CommandInterface;
import writeside.application.impl.Command;
import writeside.domain.repository.Repositroy;
import writeside.domain.repository.RepositoryStore;

public class ServiceLocator {
    

    private static CommandInterface commandInterface;
    private static Repositroy repositroy;


    public static CommandInterface commandInterface() {
        if(commandInterface == null) {
            commandInterface = new Command();
        }
        return commandInterface;
    }

    public static Repositroy repositroy() {
        if(repositroy == null) {
            repositroy = new RepositoryStore();
        }
        return repositroy;
    }


}
