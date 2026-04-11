package x3;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.components.ComponentRegistrar;
import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ua.i0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements x6.f {
    public static byte[] b(i0 i0Var, long j4) {
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(i0Var.size());
        Iterator<E> it = i0Var.iterator();
        while (it.hasNext()) {
            x1.b bVar = (x1.b) it.next();
            Bundle bundleB = bVar.b();
            Bitmap bitmap = bVar.f14252d;
            if (bitmap != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                y1.d.g(bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream));
                bundleB.putByteArray(x1.b.f14246x, byteArrayOutputStream.toByteArray());
            }
            arrayList.add(bundleB);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", arrayList);
        bundle.putLong("d", j4);
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeBundle(bundle);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }

    public List c(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (hb.b bVar : componentRegistrar.getComponents()) {
            String str = bVar.f5876a;
            if (str != null) {
                bVar = new hb.b(str, bVar.f5877b, bVar.f5878c, bVar.f5879d, bVar.f5880e, new androidx.fragment.app.e(27, str, bVar), bVar.f5881g);
            }
            arrayList.add(bVar);
        }
        return arrayList;
    }

    @Override // x6.f
    public void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
    }
}
