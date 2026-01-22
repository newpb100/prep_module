package com.amstest.test.sandbox;

import com.amstest.test.supply.markerinterfaceCatA;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// В таком виде выполнятся test1(), test3()
@RunWith(Categories.class)
@Categories.IncludeCategory(markerinterfaceCatA.class)
@Suite.SuiteClasses(JUnit4CategoriesTest.class)
public class JUnit4CategoriesAndSuitesTest {

    // Если в исходную конфигу явно пропишем эксклюд для B-маркера
    // Выполнится только test1()
    // @Categories.IncludeCategory(markerinterfaceCatA.class)
    // @Categories.ExcludeCategory(markerinterfaceCatB.class)
    // @Suite.SuiteClasses({CheckCategoriesTest.class})

    // Если в исходную конфигу пропишем иклюд для B-маркера
    // Выполнятся test1(), test2() и test3()
    // @Categories.IncludeCategory({markerinterfaceCatA.class, markerinterfaceCatB.class})
    // @Suite.SuiteClasses({CheckCategoriesTest.class})

    // Если в исходную конфигу добавим и иклюд и эксклюд для B-маркера
    // Выполнится только test1()
    // @Categories.IncludeCategory({markerinterfaceCatA.class, markerinterfaceCatB.class})
    // @Categories.ExcludeCategory(markerinterfaceCatB.class)
    // @Categories.ExcludeCategory(markerinterfaceCatB.class)

    // А если в исходной конфиге вместо
    // @Suite.SuiteClasses(JUnit4CategoriesTest.class)
    // прописать
    // @Suite.SuiteClasses({JUnit4CategoriesTest.class, JUnit4CategoriesMoreTest.class})
    // Выполнятся test1(), test3() и test4()

    // А если в исходной конфиге не указывать вообще категории
    // Выполнятся все тесты: test_categoryNone(), test1(), test2() и test3()

}
