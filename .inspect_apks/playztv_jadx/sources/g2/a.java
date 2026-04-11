package g2;

import android.net.Uri;
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
import v1.e0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements v1.h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final v1.h f4845u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final byte[] f4846v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final byte[] f4847w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CipherInputStream f4848x;

    public a(v1.h hVar, byte[] bArr, byte[] bArr2) {
        this.f4845u = hVar;
        this.f4846v = bArr;
        this.f4847w = bArr2;
    }

    @Override // v1.h
    public final void close() {
        if (this.f4848x != null) {
            this.f4848x = null;
            this.f4845u.close();
        }
    }

    @Override // v1.h
    public final void g(e0 e0Var) {
        e0Var.getClass();
        this.f4845u.g(e0Var);
    }

    @Override // v1.h
    public final long h(v1.m mVar) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            try {
                cipher.init(2, new SecretKeySpec(this.f4846v, "AES"), new IvParameterSpec(this.f4847w));
                v1.k kVar = new v1.k(this.f4845u, mVar);
                this.f4848x = new CipherInputStream(kVar, cipher);
                kVar.a();
                return -1L;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e10) {
                throw new RuntimeException(e10);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e11) {
            throw new RuntimeException(e11);
        }
    }

    @Override // v1.h
    public final Map k() {
        return this.f4845u.k();
    }

    @Override // v1.h
    public final Uri o() {
        return this.f4845u.o();
    }

    @Override // p1.i
    public final int read(byte[] bArr, int i, int i10) throws IOException {
        this.f4848x.getClass();
        int i11 = this.f4848x.read(bArr, i, i10);
        if (i11 < 0) {
            return -1;
        }
        return i11;
    }
}
