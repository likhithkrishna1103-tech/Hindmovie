package l8;

import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import o8.h0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class n extends a9.i implements h0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f7903e;

    public n(byte[] bArr) {
        super("com.google.android.gms.common.internal.ICertData");
        o8.u.b(bArr.length == 25);
        this.f7903e = Arrays.hashCode(bArr);
    }

    public static byte[] N(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e9) {
            throw new AssertionError(e9);
        }
    }

    @Override // a9.i
    public final boolean L(int i, Parcel parcel, Parcel parcel2) {
        if (i == 1) {
            v8.a aVarD = d();
            parcel2.writeNoException();
            a9.j.b(parcel2, aVarD);
            return true;
        }
        if (i != 2) {
            return false;
        }
        parcel2.writeNoException();
        parcel2.writeInt(this.f7903e);
        return true;
    }

    public abstract byte[] M();

    @Override // o8.h0
    public final int a() {
        return this.f7903e;
    }

    @Override // o8.h0
    public final v8.a d() {
        return new v8.b(M());
    }

    public final boolean equals(Object obj) {
        v8.a aVarD;
        if (obj instanceof h0) {
            try {
                h0 h0Var = (h0) obj;
                if (h0Var.a() == this.f7903e && (aVarD = h0Var.d()) != null) {
                    return Arrays.equals(M(), (byte[]) v8.b.N(aVarD));
                }
            } catch (RemoteException e9) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e9);
                return false;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f7903e;
    }
}
