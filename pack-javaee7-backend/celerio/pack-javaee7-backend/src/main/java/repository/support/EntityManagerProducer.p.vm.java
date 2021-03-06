## Copyright 2015 JAXIO http://www.jaxio.com
##
## Licensed under the Apache License, Version 2.0 (the "License");
## you may not use this file except in compliance with the License.
## You may obtain a copy of the License at
##
##    http://www.apache.org/licenses/LICENSE-2.0
##
## Unless required by applicable law or agreed to in writing, software
## distributed under the License is distributed on an "AS IS" BASIS,
## WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
## See the License for the specific language governing permissions and
## limitations under the License.
##
$output.java($RepositorySupport, "EntityManagerProducer")##

$output.require("javax.ejb.Startup")##
$output.require("javax.enterprise.context.ApplicationScoped")##
$output.require("javax.enterprise.context.RequestScoped")##
$output.require("javax.enterprise.inject.Default")##
$output.require("javax.enterprise.inject.Produces")##
$output.require("javax.inject.Named")##
$output.require("javax.persistence.EntityManager")##
$output.require("javax.persistence.PersistenceContext")##

/**
 * Annotated with {@link Startup} to force initialization of entity meta-models at startup before use of meta-models by other beans.
 */
@Named
@ApplicationScoped
@Startup
public class $output.currentClass {
    @PersistenceContext(unitName = "${configuration.applicationName}PU")
    private EntityManager entityManager;

    @Produces
    @RequestScoped
    @Default
    protected EntityManager createEntityManager() {
        return entityManager;
    }
}
