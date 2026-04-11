package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import n5.b;
import n5.c;
import n5.d;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(b bVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        d dVarH = remoteActionCompat.f648a;
        boolean z10 = true;
        if (bVar.e(1)) {
            dVarH = bVar.h();
        }
        remoteActionCompat.f648a = (IconCompat) dVarH;
        CharSequence charSequence = remoteActionCompat.f649b;
        if (bVar.e(2)) {
            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((c) bVar).f8769e);
        }
        remoteActionCompat.f649b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.f650c;
        if (bVar.e(3)) {
            charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((c) bVar).f8769e);
        }
        remoteActionCompat.f650c = charSequence2;
        remoteActionCompat.f651d = (PendingIntent) bVar.g(remoteActionCompat.f651d, 4);
        boolean z11 = remoteActionCompat.f652e;
        if (bVar.e(5)) {
            z11 = ((c) bVar).f8769e.readInt() != 0;
        }
        remoteActionCompat.f652e = z11;
        boolean z12 = remoteActionCompat.f;
        if (!bVar.e(6)) {
            z10 = z12;
        } else if (((c) bVar).f8769e.readInt() == 0) {
            z10 = false;
        }
        remoteActionCompat.f = z10;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, b bVar) {
        bVar.getClass();
        IconCompat iconCompat = remoteActionCompat.f648a;
        bVar.i(1);
        bVar.l(iconCompat);
        CharSequence charSequence = remoteActionCompat.f649b;
        bVar.i(2);
        Parcel parcel = ((c) bVar).f8769e;
        TextUtils.writeToParcel(charSequence, parcel, 0);
        CharSequence charSequence2 = remoteActionCompat.f650c;
        bVar.i(3);
        TextUtils.writeToParcel(charSequence2, parcel, 0);
        bVar.k(remoteActionCompat.f651d, 4);
        boolean z10 = remoteActionCompat.f652e;
        bVar.i(5);
        parcel.writeInt(z10 ? 1 : 0);
        boolean z11 = remoteActionCompat.f;
        bVar.i(6);
        parcel.writeInt(z11 ? 1 : 0);
    }
}
