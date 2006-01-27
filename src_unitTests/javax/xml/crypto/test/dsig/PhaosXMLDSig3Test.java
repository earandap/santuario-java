/*
 * Copyright 2006 The Apache Software Foundation.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package javax.xml.crypto.test.dsig;

import java.io.File;
import java.security.Security;
import javax.xml.crypto.KeySelector;
import javax.xml.crypto.dsig.XMLSignatureException;

import junit.framework.*;

import javax.xml.crypto.test.KeySelectors;

/**
 * This is a testcase to validate all "phaos-xmldsig-three" 
 * testcases from Phaos
 */
public class PhaosXMLDSig3Test extends TestCase {

    private SignatureValidator validator;
    private File base;

    static {
        Security.insertProviderAt
            (new org.jcp.xml.dsig.internal.dom.XMLDSigRI(), 1);
    }

    public PhaosXMLDSig3Test(String name) {
        super(name);

	String fs = System.getProperty("file.separator");
	base = new File(System.getProperty("basedir") + fs + "data" + fs +
	    "com" + fs + "phaos", "phaos-xmldsig-three");
	validator = new SignatureValidator(base);
    }
//    public void test_signature_big() throws Exception {
//        String file = "signature-big.xml";
//
//        boolean coreValidity = validator.validate(file, 
//		new KeySelectors.CollectionKeySelector(base));
//        assertTrue("Signature failed core validation", coreValidity);
//    }
    public void test_signature_dsa_detached() throws Exception {
	String file = "signature-dsa-detached.xml";

	boolean coreValidity = 
	    validator.validate(file, new KeySelectors.RawX509KeySelector());
	assertTrue("Signature failed core validation", coreValidity);
    }
    public void test_signature_dsa_enveloped() throws Exception {
	String file = "signature-dsa-enveloped.xml";

	boolean coreValidity = 
	    validator.validate(file, new KeySelectors.RawX509KeySelector());
	assertTrue("Signature failed core validation", coreValidity);
    }    
    public void test_signature_dsa_enveloping() throws Exception {
	String file = "signature-dsa-enveloping.xml";

	boolean coreValidity = 
	    validator.validate(file, new KeySelectors.RawX509KeySelector());
	assertTrue("Signature failed core validation", coreValidity);
    }
    public void test_signature_dsa_manifest() throws Exception {
	String file = "signature-dsa-manifest.xml";

	boolean coreValidity = 
	    validator.validate(file, new KeySelectors.KeyValueKeySelector());
	assertTrue("Signature failed core validation", coreValidity);
    }
    public void test_signature_hmac_sha1_40_c14n_comments_detached() 
	throws Exception {
        String file = "signature-hmac-sha1-40-c14n-comments-detached.xml";
        
	KeySelector ks = new KeySelectors.SecretKeySelector
	    ("test".getBytes("ASCII") );
	boolean coreValidity = validator.validate(file, ks);
	assertTrue("Signature failed core validation", coreValidity);
    }
    public void test_signature_hmac_sha1_40_exclusive_c14n_comments_detached() 
	throws Exception {
        String file = "signature-hmac-sha1-40-exclusive-c14n-comments-detached.xml";
        
	KeySelector ks = new KeySelectors.SecretKeySelector
	    ("test".getBytes("ASCII") );
	boolean coreValidity = validator.validate(file, ks);
	assertTrue("Signature failed core validation", coreValidity);
    }
    public void test_signature_hmac_sha1_exclusive_c14n_comments_detached() 
	throws Exception {
        String file = "signature-hmac-sha1-exclusive-c14n-comments-detached.xml";
        
	KeySelector ks = new KeySelectors.SecretKeySelector
	    ("test".getBytes("ASCII") );
	boolean coreValidity = validator.validate(file, ks);
	assertTrue("Signature failed core validation", coreValidity);
    }
    public void test_signature_hmac_sha1_exclusive_c14n_enveloped() 
	throws Exception {
        String file = "signature-hmac-sha1-exclusive-c14n-enveloped.xml";
        
	KeySelector ks = new KeySelectors.SecretKeySelector
	    ("test".getBytes("ASCII") );
	boolean coreValidity = validator.validate(file, ks);
	assertTrue("Signature failed core validation", coreValidity);
    }
    public void test_signature_rsa_detached_b64_transform() throws Exception {
	String file = "signature-rsa-detached-b64-transform.xml";

	boolean coreValidity = 
	    validator.validate(file, new KeySelectors.KeyValueKeySelector());
	assertTrue("Signature failed core validation", coreValidity);
    }
    public void test_signature_rsa_detached_xpath_transform() throws Exception {
	String file = "signature-rsa-detached-xpath-transform.xml";

	boolean coreValidity = 
	    validator.validate(file, new KeySelectors.KeyValueKeySelector());
	assertTrue("Signature failed core validation", coreValidity);
    }    
    public void test_signature_rsa_detached_xslt_transform_bad_rm() throws Exception {
	String file = "signature-rsa-detached-xslt-transform-bad-retrieval-method.xml";

	try {
	    boolean coreValidity = 
	        validator.validate(file, 
			       new KeySelectors.CollectionKeySelector(base));
	    fail("Should throw XMLSignatureException for using DSA key with " +
		 "RSA algorithm");
	} catch (XMLSignatureException xse) {}
    }
    public void test_signature_rsa_detached_xslt_transform_rm() throws Exception {
	String file = "signature-rsa-detached-xslt-transform-retrieval-method.xml";

	boolean coreValidity = 
	    validator.validate(file, 
			       new KeySelectors.CollectionKeySelector(base));
	assertTrue("Signature failed core validation", coreValidity);
    }
    public void test_signature_rsa_detached_xslt_transform() throws Exception {
	String file = "signature-rsa-detached-xslt-transform.xml";

	boolean coreValidity = 
	    validator.validate(file, new KeySelectors.KeyValueKeySelector());
	assertTrue("Signature failed core validation", coreValidity);
    }
    public void test_signature_rsa_detached() throws Exception {
	String file = "signature-rsa-detached.xml";

	boolean coreValidity = 
	    validator.validate(file, new KeySelectors.RawX509KeySelector());
	assertTrue("Signature failed core validation", coreValidity);
    }
    public void test_signature_rsa_enveloped_bad_digest_val() throws Exception {
	String file = "signature-rsa-enveloped-bad-digest-val.xml";

	boolean coreValidity = 
	    validator.validate(file, new KeySelectors.RawX509KeySelector());
	assertFalse("Signature should fail core validation", coreValidity);
    }
    public void test_signature_rsa_enveloped() throws Exception {
	String file = "signature-rsa-enveloped.xml";

	boolean coreValidity =
	    validator.validate(file, new KeySelectors.RawX509KeySelector());
	assertTrue("Signature failed core validation", coreValidity);
    }
    public void test_signature_rsa_enveloping() throws Exception {
	String file = "signature-rsa-enveloping.xml";

	boolean coreValidity = 
	    validator.validate(file, new KeySelectors.RawX509KeySelector());
	assertTrue("Signature failed core validation", coreValidity);
   }
   public void test_signature_rsa_manifest_x509_data_cert_chain() throws Exception {
        String file = "signature-rsa-manifest-x509-data-cert-chain.xml";

        boolean coreValidity =
            validator.validate(file, new KeySelectors.RawX509KeySelector());
        assertTrue("Signature failed core validation", coreValidity);
   }
   public void test_signature_rsa_manifest_x509_data_cert() throws Exception {
        String file = "signature-rsa-manifest-x509-data-cert.xml";

        boolean coreValidity =
            validator.validate(file, new KeySelectors.RawX509KeySelector());
        assertTrue("Signature failed core validation", coreValidity);
   }
   public void test_signature_rsa_manifest_x509_data_issuer_serial() throws Exception {
        String file = "signature-rsa-manifest-x509-data-issuer-serial.xml";

        boolean coreValidity = validator.validate(file, 
		new KeySelectors.CollectionKeySelector(base));
        assertTrue("Signature failed core validation", coreValidity);
   }
   public void test_signature_rsa_manifest_x509_data_ski() throws Exception {
        String file = "signature-rsa-manifest-x509-data-ski.xml";

        boolean coreValidity = validator.validate(file, 
		new KeySelectors.CollectionKeySelector(base));
        assertTrue("Signature failed core validation", coreValidity);
   }
   public void test_signature_rsa_manifest_x509_data_subject_name() throws Exception {
        String file = "signature-rsa-manifest-x509-data-subject-name.xml";

        boolean coreValidity = validator.validate(file, 
		new KeySelectors.CollectionKeySelector(base));
        assertTrue("Signature failed core validation", coreValidity);
   }
   public void test_signature_rsa_manifest_x509_data() throws Exception {
        String file = "signature-rsa-manifest-x509-data.xml";

        boolean coreValidity =
            validator.validate(file, new KeySelectors.RawX509KeySelector());
        assertTrue("Signature failed core validation", coreValidity);
   }
   public void test_signature_rsa_manifest() throws Exception {
        String file = "signature-rsa-manifest.xml";

        boolean coreValidity =
            validator.validate(file, new KeySelectors.KeyValueKeySelector());
        assertTrue("Signature failed core validation", coreValidity);
   }
   public void test_signature_rsa_xpath_transform_enveloped() throws Exception {
        String file = "signature-rsa-xpath-transform-enveloped.xml";

        boolean coreValidity =
            validator.validate(file, new KeySelectors.RawX509KeySelector());
        assertTrue("Signature failed core validation", coreValidity);
   }
   public static void main(String[] args) throws Exception {
        PhaosXMLDSig3Test pt = new PhaosXMLDSig3Test("");
//	pt.test_signature_big();
        pt.test_signature_dsa_detached();
        pt.test_signature_dsa_enveloped();
	pt.test_signature_dsa_enveloping();
	pt.test_signature_dsa_manifest();
	pt.test_signature_hmac_sha1_40_c14n_comments_detached();
	pt.test_signature_hmac_sha1_40_exclusive_c14n_comments_detached();
	pt.test_signature_hmac_sha1_exclusive_c14n_comments_detached(); 
	pt.test_signature_hmac_sha1_exclusive_c14n_enveloped();
	pt.test_signature_rsa_detached_b64_transform();
	pt.test_signature_rsa_detached_xpath_transform();
	pt.test_signature_rsa_detached_xslt_transform_bad_rm();
	pt.test_signature_rsa_detached_xslt_transform_rm();
	pt.test_signature_rsa_detached_xslt_transform();
	pt.test_signature_rsa_detached();
	pt.test_signature_rsa_enveloped_bad_digest_val();
	pt.test_signature_rsa_enveloped();
	pt.test_signature_rsa_enveloping();
	pt.test_signature_rsa_manifest_x509_data_cert_chain();
	pt.test_signature_rsa_manifest_x509_data_cert();
	pt.test_signature_rsa_manifest_x509_data_issuer_serial();
	pt.test_signature_rsa_manifest_x509_data_ski();
	pt.test_signature_rsa_manifest_x509_data_subject_name();
	pt.test_signature_rsa_manifest_x509_data();
	pt.test_signature_rsa_manifest();
	pt.test_signature_rsa_xpath_transform_enveloped();
    }
}
