package f9;

import android.os.Parcel;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j0 extends a9.a implements k0 {
    @Override // f9.k0
    public final void E(List list) {
        Parcel parcelF = f();
        parcelF.writeTypedList(list);
        M(parcelF);
    }
}
