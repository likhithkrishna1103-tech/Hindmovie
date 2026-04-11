package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import i5.b;
import i5.c;
import i5.d;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(b bVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        d dVarH = remoteActionCompat.f973a;
        boolean z2 = true;
        if (bVar.e(1)) {
            dVarH = bVar.h();
        }
        remoteActionCompat.f973a = (IconCompat) dVarH;
        CharSequence charSequence = remoteActionCompat.f974b;
        if (bVar.e(2)) {
            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((c) bVar).f6370e);
        }
        remoteActionCompat.f974b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.f975c;
        if (bVar.e(3)) {
            charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((c) bVar).f6370e);
        }
        remoteActionCompat.f975c = charSequence2;
        remoteActionCompat.f976d = (PendingIntent) bVar.g(remoteActionCompat.f976d, 4);
        boolean z10 = remoteActionCompat.f977e;
        if (bVar.e(5)) {
            z10 = ((c) bVar).f6370e.readInt() != 0;
        }
        remoteActionCompat.f977e = z10;
        boolean z11 = remoteActionCompat.f;
        if (!bVar.e(6)) {
            z2 = z11;
        } else if (((c) bVar).f6370e.readInt() == 0) {
            z2 = false;
        }
        remoteActionCompat.f = z2;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, b bVar) {
        bVar.getClass();
        IconCompat iconCompat = remoteActionCompat.f973a;
        bVar.i(1);
        bVar.l(iconCompat);
        CharSequence charSequence = remoteActionCompat.f974b;
        bVar.i(2);
        Parcel parcel = ((c) bVar).f6370e;
        TextUtils.writeToParcel(charSequence, parcel, 0);
        CharSequence charSequence2 = remoteActionCompat.f975c;
        bVar.i(3);
        TextUtils.writeToParcel(charSequence2, parcel, 0);
        bVar.k(remoteActionCompat.f976d, 4);
        boolean z2 = remoteActionCompat.f977e;
        bVar.i(5);
        parcel.writeInt(z2 ? 1 : 0);
        boolean z10 = remoteActionCompat.f;
        bVar.i(6);
        parcel.writeInt(z10 ? 1 : 0);
    }
}
