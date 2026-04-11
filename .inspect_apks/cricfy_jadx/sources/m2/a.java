package m2;

import android.net.Uri;
import b2.h0;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements b2.h {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final b2.h f8038v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final byte[] f8039w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final byte[] f8040x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public CipherInputStream f8041y;

    public a(b2.h hVar, byte[] bArr, byte[] bArr2) {
        this.f8038v = hVar;
        this.f8039w = bArr;
        this.f8040x = bArr2;
    }

    @Override // b2.h
    public final long B(b2.o oVar) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            try {
                cipher.init(2, new SecretKeySpec(this.f8039w, "AES"), new IvParameterSpec(this.f8040x));
                b2.m mVar = new b2.m(this.f8038v, oVar);
                this.f8041y = new CipherInputStream(mVar, cipher);
                mVar.a();
                return -1L;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e9) {
                throw new RuntimeException(e9);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e10) {
            throw new RuntimeException(e10);
        }
    }

    @Override // b2.h
    public final void close() {
        if (this.f8041y != null) {
            this.f8041y = null;
            this.f8038v.close();
        }
    }

    @Override // b2.h
    public final void d(h0 h0Var) {
        h0Var.getClass();
        this.f8038v.d(h0Var);
    }

    @Override // b2.h
    public final Map j() {
        return this.f8038v.j();
    }

    @Override // v1.h
    public final int read(byte[] bArr, int i, int i10) throws IOException {
        this.f8041y.getClass();
        int i11 = this.f8041y.read(bArr, i, i10);
        if (i11 < 0) {
            return -1;
        }
        return i11;
    }

    @Override // b2.h
    public final Uri t() {
        return this.f8038v.t();
    }
}
