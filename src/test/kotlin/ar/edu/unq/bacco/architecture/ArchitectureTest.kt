package ar.edu.unq.bacco.architecture

import com.tngtech.archunit.core.domain.JavaClasses
import com.tngtech.archunit.core.importer.ImportOption
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.ArchRule
import jakarta.persistence.Entity
import org.junit.jupiter.api.DisplayName
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RestController

@DisplayName("Architecture's test")
@AnalyzeClasses(
    packages = ["ar.edu.unq.bacco"],
    importOptions = [ImportOption.DoNotIncludeTests::class, ImportOption.DoNotIncludeJars::class]
)
class ArchitectureTest {

    @DisplayName("DTOs have simple name ending with DTO")
    @ArchTest
    fun testDtosHaveSimpleNameEndingWithDTO(classes: JavaClasses) {
        val myRule: ArchRule = com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes()
            .that().resideInAPackage("..model.dto")
            .should().haveSimpleNameEndingWith("DTO")
        myRule.check(classes)
    }

    @DisplayName("Controllers have simple name ending with Controller")
    @ArchTest
    fun testControllersHaveSimpleNameEndingWithController(classes: JavaClasses) {
        val myRule: ArchRule = com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes()
            .that().resideInAPackage("..controllers")
            .should().haveSimpleNameEndingWith("Controller")
        myRule.check(classes)
    }

    @DisplayName("Controllers are annotated with RestController annotation")
    @ArchTest
    fun testControllersAreAnnotatedWithRestControllerAnnotation(classes: JavaClasses) {
        val myRule: ArchRule = com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes()
            .that().resideInAPackage("..webservice.controllers")
            .should().beAnnotatedWith(RestController::class.java)
        myRule.check(classes)
    }

    @DisplayName("Repositories must be interfaces")
    @ArchTest
    fun testRepositoriesMustBeInterfaces(classes: JavaClasses) {
        val myRule: ArchRule = com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes()
            .that().resideInAPackage("..repository")
            .should().beInterfaces()
        myRule.check(classes)
    }

    @DisplayName("Services must be interfaces")
    @ArchTest
    fun serviceInterfacesMustBeInterfaces(classes: JavaClasses) {
        val myRule: ArchRule = com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes()
            .that().resideInAPackage("..service.interfaces")
            .should().beInterfaces()
        myRule.check(classes)
    }

    @DisplayName("Services are annotated with Service annotation")
    @ArchTest
    fun testServicesAreAnnotatedWithServiceAnnotation(classes: JavaClasses) {
        val myRule: ArchRule = com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes()
            .that().resideInAPackage("..service")
            .should().beAnnotatedWith(Service::class.java)
        myRule.check(classes)
    }

    @DisplayName("Services have simple name ending with Service")
    @ArchTest
    fun servicesHaveSimpleNameEndingWithServices(classes: JavaClasses) {
        val myRule: ArchRule = com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes()
            .that().resideInAPackage("..service")
            .should().haveSimpleNameEndingWith("Service")
        myRule.check(classes)
    }

    @DisplayName("1 - Services are only accessed by controllers and services")
    @ArchTest
    fun testServicesAreOnlyAccessedByControllersAndServices(classes: JavaClasses) {
        val myRule: ArchRule = com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes()
            .that().resideInAPackage("..service")
            .should().onlyBeAccessed().byAnyPackage("..controller..", "..service..")
        myRule.check(classes)
    }

    @DisplayName("Repositories must reside in a repository package")
    @ArchTest
    fun testRepositoriesMustResideInARepositoryPackage(classes: JavaClasses) {
        val myRule: ArchRule = com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes()
            .that().haveNameMatching(".*Repository")
            .should().resideInAPackage("..repository..")
            .`as`("Repositories should reside in a package '..repository..'")
        myRule.check(classes)
    }

    @DisplayName("Entities should reside in a package ..model..")
    @ArchTest
    fun testEntitiesMustResideInADomainPackage(classes: JavaClasses) {
        val myRule: ArchRule = com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes()
            .that().areAnnotatedWith(Entity::class.java)
            .should().resideInAPackage("..model..")
        myRule.check(classes)
    }

    @DisplayName("Methods of controllers are public and should have raw return type ResponseEntity")
    @ArchTest
    fun testMethodOfControllersArePublicAndShouldHaveRawReturnTypeResponseEntity(classes: JavaClasses) {
        val myRule: ArchRule = com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods()
            .that().areDeclaredInClassesThat().resideInAPackage("..controllers..")
            .and().arePublic()
            .should().haveRawReturnType(ResponseEntity::class.java)
            .because("we do not want to couple the client code directly to the return types of the encapsulated module")
        myRule.check(classes)
    }
}