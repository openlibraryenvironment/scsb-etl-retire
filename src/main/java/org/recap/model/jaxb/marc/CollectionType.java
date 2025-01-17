
package org.recap.model.jaxb.marc;

import org.apache.log4j.Logger;
import org.recap.model.jaxb.JAXBContextHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for collectionType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="collectionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *         &lt;element ref="{}record"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{}idDataType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "collection", propOrder = {
        "record"
})

@XmlRootElement(name = "collection")
public class CollectionType implements Serializable {

    private static final Logger LOG = Logger.getLogger(CollectionType.class);

    @XmlElement(nillable = true)
    protected List<RecordType> record;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;

    /**
     * Gets the value of the record property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the record property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecord().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link RecordType }
     */
    public List<RecordType> getRecord() {
        if (record == null) {
            record = new ArrayList<RecordType>();
        }
        return this.record;
    }

    public void setRecord(List<RecordType> record) {
        this.record = record;
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setId(String value) {
        this.id = value;
    }

    public String serialize(Object object) {
        String result = null;
        CollectionType collectionType = (CollectionType) object;
        try {
            StringWriter stringWriter = new StringWriter();
            Marshaller jaxbMarshaller = JAXBContextHandler.getInstance().getJAXBContextForClass(CollectionType.class).createMarshaller();
            synchronized (jaxbMarshaller) {
                jaxbMarshaller.marshal(collectionType, stringWriter);
            }
            result = stringWriter.toString();
        } catch (Exception e) {
            LOG.error("Exception :", e);
        }
        return result;
    }

    public Object deserialize(String collectionTypeXml) {
        CollectionType collectionType = new CollectionType();
        try {
            Unmarshaller unmarshaller = JAXBContextHandler.getInstance().getJAXBContextForClass(CollectionType.class).createUnmarshaller();

            collectionType = (CollectionType) unmarshaller.unmarshal(new StringReader(collectionTypeXml));
        } catch (Exception e) {
            LOG.error("Exception :", e);
        }
        return collectionType;
    }


}
