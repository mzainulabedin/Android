/*
 * Copyright (C) 2011 Markus Junginger, greenrobot (http://greenrobot.de)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.greenrobot.daogenerator.gentest;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;

/**
 * Generates entities and DAOs for the example project DaoExample.
 * 
 * Run it as a Java application (not Android).
 * 
 * @author Markus
 */
public class MShoppingDaoGenerator {

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(3, "com.sandz.mshopping.dao");

        Entity category = addCategory(schema);
        Entity item = addItem(schema, category);
        addMonthItem(schema, item);

        DaoGenerator daoGenerator = new DaoGenerator();
        //daoGenerator.generateAll(schema, "src-gen");
        daoGenerator.generateEntities(schema, "..\\mshopping\\src", "com.sandz.mshopping.beans");
        daoGenerator.generateDao(schema, "..\\mshopping\\src", "com.sandz.mshopping.dao");
    }

    private static Entity addCategory(Schema schema) {
        Entity category = schema.addEntity("Category");
        category.setTableName("CATEGORIES");
        category.addIdProperty().autoincrement();
        category.addStringProperty("name").notNull();
        category.addStringProperty("description");
        category.addStringProperty("pictureId");

        category.addDateProperty("createdOn").notNull();
        category.addDateProperty("modifiedOn").notNull();

        return category;
    }

    private static Entity addItem(Schema schema, Entity category) {
        Entity item = schema.addEntity("Item");
        item.setTableName("ITEMS");
        item.addIdProperty().autoincrement();
        Property itemName = item.addStringProperty("name").notNull().getProperty();
        item.addStringProperty("description");

        item.addStringProperty("tags");
        item.addStringProperty("pictureId");
        item.addBooleanProperty("isOptional");

        item.addDateProperty("createdOn").notNull();
        item.addDateProperty("modifiedOn").notNull();

        Property categoryId = item.addLongProperty("categoryId").getProperty();
        item.addToOne(category, categoryId);

        ToMany categoryToItems = category.addToMany(item, categoryId);
        categoryToItems.setName("items");
        categoryToItems.orderAsc(itemName);

        return item;
    }

    private static Entity addMonthItem(Schema schema, Entity item) {
        Entity monthItem = schema.addEntity("MonthItem");
        monthItem.setTableName("MONTH_ITEMS");
        monthItem.addIdProperty().autoincrement();
        Property monthItemDate = monthItem.addDateProperty("month").notNull().getProperty();
        monthItem.addStringProperty("comment");

        monthItem.addFloatProperty("quantity");
        monthItem.addFloatProperty("price");
        monthItem.addFloatProperty("discount");
        monthItem.addFloatProperty("totalPrice");

        monthItem.addDateProperty("createdOn").notNull();
        monthItem.addDateProperty("modifiedOn").notNull();

        Property itemId = monthItem.addLongProperty("itemId").getProperty();
        monthItem.addToOne(item, itemId);

        ToMany itemToMonthItems = item.addToMany(monthItem, itemId);
        itemToMonthItems.setName("monthItems");
        itemToMonthItems.orderAsc(monthItemDate);

        return monthItem;
    }
}
