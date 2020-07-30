/*
 * MIT License
 *
 * Copyright (c) 2020.  Hossein Zafari/novinfar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package hosseinzafari.github.sales.struct;

import java.util.ArrayList;
import java.util.List;

import hosseinzafari.github.sales.R;

public class DataProvider {


    public static List<Person> getdata() {
        List<Person> people = new ArrayList();

        Person person = new Person();
        person.setName("امیرمهدی");
        person.setField("برنامه نویس");
        person.setDisc("متن کپی شده متن کپی شده متن کپی شده متن کپی شده متن کپی شده");
        person.setImage(R.drawable.face);
        people.add(person);

        Person person2 = new Person();
        person2.setName("حسین ظفری");
        person2.setField("برنامه نویس");
        person2.setDisc("متن کپی شده متن کپی شده متن کپی شده متن کپی شده ");
        person2.setImage(R.drawable.face2);

        people.add(person2);

        Person person3 = new Person();
        person3.setName("علی مرادی");
        person3.setField("طراح");
        person3.setDisc("متن کپی شده متن کپی شده متن کپی شده متن کپی شده متن کپی شده متن کپی شده متن کپی شده متن کپی شده متن کپی شده");
        person3.setImage(R.drawable.face3);

        people.add(person3);

        Person person4 = new Person();
        person4.setName("مهدی مراد جم");
        person4.setField("طراح سایت");
        person4.setDisc("متن کپی شدهمتن کپی شدهمتن کپی شدهمتن کپی شدهمتن کپی شده");
        person4.setImage(R.drawable.face4);

        people.add(person4);

        Person person5 = new Person();
        person5.setName("محمد جهانگیری ");
        person5.setField("طراح سایت");
        person5.setDisc("متن کپی شدهمتن کپی شدهمتن کپی شدهمتن کپی شدهمتن کپی شده");
        person5.setImage(R.drawable.face2);

        people.add(person5);

        Person person6 = new Person();
        person6.setName("امیرعلی مهر جویی");
        person6.setField("بازاریاب");
        person6.setDisc("متن کپی شدهمتن کپی شدهمتن کپی شدهمتن کپی شدهمتن کپی شده");
        person6.setImage(R.drawable.face4);

        people.add(person6);

        Person person7 = new Person();
        person7.setName("مهدی مراد جم");
        person7.setField("طراح سایت");
        person7.setDisc("متن کپی شدهمتن کپی شدهمتن کپی شدهمتن کپی شدهمتن کپی شده");
        person7.setImage(R.drawable.face);

        people.add(person7);
        people.add(person4);
        people.add(person3);
        people.add(person2);
        people.add(person6);
        people.add(person4);
        people.add(person2);
        people.add(person7);
        people.add(person4);
        people.add(person3);
        people.add(person2);
        people.add(person6);
        people.add(person4);
        people.add(person2);
        people.add(person2);
        people.add(person7);
        people.add(person4);
        people.add(person3);
        people.add(person2);
        people.add(person6);
        people.add(person4);
        people.add(person2);
        people.add(person7);
        people.add(person4);
        people.add(person3);
        people.add(person2);
        people.add(person6);
        people.add(person4);
        people.add(person2);

        return people;
    }
}
