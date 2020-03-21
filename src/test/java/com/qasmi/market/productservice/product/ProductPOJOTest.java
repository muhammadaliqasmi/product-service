
package com.qasmi.market.productservice.product;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;

import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.NoPublicFieldsExceptStaticFinalRule;
import com.openpojo.validation.rule.impl.NoStaticExceptFinalRule;
import com.openpojo.validation.rule.impl.SerializableMustHaveSerialVersionUIDRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import com.qasmi.market.productservice.test.AbstractTest;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

/**
 * {@link ProductPOJOTest} implements test cases for {@link Product}.
 * 
 * @author Muhammad Ali Qasmi
 */
public class ProductPOJOTest extends AbstractTest {

    @Test
    public void shouldValidateFilePojo() {
        final Validator validator;
        validator = ValidatorBuilder.create() //
                .with(new GetterMustExistRule()) //
                .with(new SetterMustExistRule()) //
                .with(new NoPublicFieldsExceptStaticFinalRule()) //
                .with(new NoStaticExceptFinalRule()) //
                .with(new SerializableMustHaveSerialVersionUIDRule()) //
                .with(new SetterTester()) //
                .with(new GetterTester()) //
                .build();
        validator.validate(PojoClassFactory.getPojoClass(Product.class));
    }

    @Test
    public void shouldFollowEqualsContract() {
        EqualsVerifier.forClass(Product.class) //
                .suppress(Warning.ALL_FIELDS_SHOULD_BE_USED) //
                .verify();
    }

    @Test
    public void shouldHasToString() {
        final Product product = new Product("sample-category","sample-product");
        assertThat(ObjectUtils.identityToString(product), not(product.toString()));
    }

}
