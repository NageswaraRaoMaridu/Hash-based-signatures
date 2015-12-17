package ots;

import java.math.BigInteger;

import org.apache.commons.lang3.ArrayUtils;

import signatures.PrivateKey;

public class PrivateKeyWinternitz implements PrivateKey {

    BigInteger[] x;

    public PrivateKeyWinternitz(BigInteger[] x) {
	this.x = x;
    }

    public BigInteger[] getX() {
	return this.x;
    }

    public BigInteger getX(int i) {
	return this.x[i];
    }

    @Override
    public byte[] toByteArray() {
	byte[] data = this.x[0].toByteArray();
	for (int i = 1; i < this.x.length; ++i) {
	    data = ArrayUtils.addAll(data, this.x[i].toByteArray());
	}
	return data;
    }

}
