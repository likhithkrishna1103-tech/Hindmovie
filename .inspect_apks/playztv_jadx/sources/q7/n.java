package q7;

import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import t7.v;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class n extends d8.a implements t7.q {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f11056e;

    public n(byte[] bArr) {
        super("com.google.android.gms.common.internal.ICertData");
        v.a(bArr.length == 25);
        this.f11056e = Arrays.hashCode(bArr);
    }

    public static byte[] H(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // d8.a
    public final boolean G(int i, Parcel parcel, Parcel parcel2) {
        if (i == 1) {
            a8.a aVarB = b();
            parcel2.writeNoException();
            f8.a.c(parcel2, aVarB);
            return true;
        }
        if (i != 2) {
            return false;
        }
        parcel2.writeNoException();
        parcel2.writeInt(this.f11056e);
        return true;
    }

    public abstract byte[] I();

    @Override // t7.q
    public final a8.a b() {
        return new a8.b(I());
    }

    public final boolean equals(Object obj) {
        a8.a aVarB;
        if (obj != null && (obj instanceof t7.q)) {
            try {
                t7.q qVar = (t7.q) obj;
                if (qVar.j() == this.f11056e && (aVarB = qVar.b()) != null) {
                    return Arrays.equals(I(), (byte[]) a8.b.I(aVarB));
                }
            } catch (RemoteException e10) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e10);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f11056e;
    }

    @Override // t7.q
    public final int j() {
        return this.f11056e;
    }
}
