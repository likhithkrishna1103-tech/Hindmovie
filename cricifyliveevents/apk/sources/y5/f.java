package y5;

import android.os.Parcelable;
import androidx.media3.decoder.DecoderInputBuffer;
import l4.o;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14937a;

    public /* synthetic */ f(int i) {
        this.f14937a = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006f  */
    @Override // android.os.Parcelable.Creator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object createFromParcel(android.os.Parcel r14) {
        /*
            r13 = this;
            int r0 = r13.f14937a
            switch(r0) {
                case 0: goto L7c;
                default: goto L5;
            }
        L5:
            android.os.Parcelable$Creator r0 = android.media.MediaDescription.CREATOR
            java.lang.Object r14 = r0.createFromParcel(r14)
            android.media.MediaDescription r14 = (android.media.MediaDescription) r14
            java.lang.String r1 = r14.getMediaId()
            java.lang.CharSequence r2 = r14.getTitle()
            java.lang.CharSequence r3 = r14.getSubtitle()
            java.lang.CharSequence r4 = r14.getDescription()
            android.graphics.Bitmap r5 = r14.getIconBitmap()
            android.net.Uri r6 = r14.getIconUri()
            android.os.Bundle r0 = r14.getExtras()
            r7 = 0
            if (r0 != 0) goto L2e
        L2c:
            r0 = r7
            goto L3d
        L2e:
            l4.c0.K(r0)
            r0.isEmpty()     // Catch: android.os.BadParcelableException -> L35
            goto L3d
        L35:
            java.lang.String r0 = "MediaSessionCompat"
            java.lang.String r8 = "Could not unparcel the data."
            android.util.Log.e(r0, r8)
            goto L2c
        L3d:
            if (r0 == 0) goto L45
            android.os.Bundle r8 = new android.os.Bundle
            r8.<init>(r0)
            r0 = r8
        L45:
            if (r0 == 0) goto L69
            java.lang.String r8 = "android.support.v4.media.description.MEDIA_URI"
            android.os.Parcelable r9 = r0.getParcelable(r8)
            android.net.Uri r9 = (android.net.Uri) r9
            if (r9 == 0) goto L67
            java.lang.String r10 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r11 = r0.containsKey(r10)
            if (r11 == 0) goto L61
            int r11 = r0.size()
            r12 = 2
            if (r11 != r12) goto L61
            goto L6b
        L61:
            r0.remove(r8)
            r0.remove(r10)
        L67:
            r7 = r0
            goto L6b
        L69:
            r9 = r7
            goto L67
        L6b:
            if (r9 == 0) goto L6f
        L6d:
            r8 = r9
            goto L74
        L6f:
            android.net.Uri r9 = r14.getMediaUri()
            goto L6d
        L74:
            l4.o r0 = new l4.o
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0.D = r14
            return r0
        L7c:
            y5.g r0 = new y5.g
            r0.<init>()
            java.lang.String r1 = "pronull"
            r0.f14942z = r1
            r1 = 0
            r0.A = r1
            java.lang.String r2 = r14.readString()
            r0.f14938v = r2
            java.lang.String r2 = r14.readString()
            r0.f14939w = r2
            java.lang.String r2 = r14.readString()
            r0.f14940x = r2
            java.lang.String r2 = r14.readString()
            r0.f14941y = r2
            java.lang.String r2 = r14.readString()
            r0.f14942z = r2
            int r2 = r14.readInt()
            r0.A = r2
            int r14 = r14.readInt()
            r2 = 1
            if (r14 != r2) goto Lb4
            r1 = r2
        Lb4:
            r0.B = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: y5.f.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f14937a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new g[i];
            default:
                return new o[i];
        }
    }
}
