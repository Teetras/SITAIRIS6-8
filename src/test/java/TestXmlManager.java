import firstwebapp.xmlmanager.*;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.JUnit4;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestXmlManager {

    private XmlManager<Pair<Integer, List<Product>>> manager;
    private XmlReaderTest reader;

    @Before
    public void setup(){
        this.reader = new XmlReaderTest();
        this.manager = new XmlManagerImpl("",reader);

    }

    @Test()
    public void testReadFromFile(){
        Pair<Integer, List<Product>> expected = new MutablePair<>(0, Collections.emptyList());
        reader.setResult(expected);

        Pair<Integer, List<Product>> actual = manager.readFromFile();

        assertEquals(expected.getLeft(),actual.getLeft());
        assertEquals(expected.getRight(),actual.getRight());
    }

    private class XmlReaderTest implements XmlReader<Pair<Integer, List<Product>>>{

        private Pair<Integer, List<Product>> result;

        void setResult(Pair<Integer, List<Product>> result){
            this.result = result;
        }

        @Override
        public Pair<Integer, List<Product>> readFromFile(String filePath) {
            return result;
        }
    }
}
