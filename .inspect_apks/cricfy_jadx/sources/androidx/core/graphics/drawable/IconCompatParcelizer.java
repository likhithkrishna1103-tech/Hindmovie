package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.decoder.DecoderInputBuffer;
import g1.h;
import java.nio.charset.Charset;
import n5.b;
import n5.c;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class IconCompatParcelizer {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static IconCompat read(b bVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f659a = bVar.f(iconCompat.f659a, 1);
        byte[] bArr = iconCompat.f661c;
        if (bVar.e(2)) {
            Parcel parcel = ((c) bVar).f8769e;
            int i = parcel.readInt();
            if (i < 0) {
                bArr = null;
            } else {
                byte[] bArr2 = new byte[i];
                parcel.readByteArray(bArr2);
                bArr = bArr2;
            }
        }
        iconCompat.f661c = bArr;
        iconCompat.f662d = bVar.g(iconCompat.f662d, 3);
        iconCompat.f663e = bVar.f(iconCompat.f663e, 4);
        iconCompat.f = bVar.f(iconCompat.f, 5);
        iconCompat.f664g = (ColorStateList) bVar.g(iconCompat.f664g, 6);
        String string = iconCompat.i;
        if (bVar.e(7)) {
            string = ((c) bVar).f8769e.readString();
        }
        iconCompat.i = string;
        String string2 = iconCompat.f666j;
        if (bVar.e(8)) {
            string2 = ((c) bVar).f8769e.readString();
        }
        iconCompat.f666j = string2;
        iconCompat.f665h = PorterDuff.Mode.valueOf(iconCompat.i);
        switch (iconCompat.f659a) {
            case -1:
                Parcelable parcelable = iconCompat.f662d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                iconCompat.f660b = parcelable;
                return iconCompat;
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
            default:
                return iconCompat;
            case 1:
            case h.STRING_FIELD_NUMBER /* 5 */:
                Parcelable parcelable2 = iconCompat.f662d;
                if (parcelable2 != null) {
                    iconCompat.f660b = parcelable2;
                    return iconCompat;
                }
                byte[] bArr3 = iconCompat.f661c;
                iconCompat.f660b = bArr3;
                iconCompat.f659a = 3;
                iconCompat.f663e = 0;
                iconCompat.f = bArr3.length;
                return iconCompat;
            case 2:
            case h.LONG_FIELD_NUMBER /* 4 */:
            case h.STRING_SET_FIELD_NUMBER /* 6 */:
                String str = new String(iconCompat.f661c, Charset.forName("UTF-16"));
                iconCompat.f660b = str;
                if (iconCompat.f659a == 2 && iconCompat.f666j == null) {
                    iconCompat.f666j = str.split(":", -1)[0];
                }
                return iconCompat;
            case 3:
                iconCompat.f660b = iconCompat.f661c;
                return iconCompat;
        }
    }

    public static void write(IconCompat iconCompat, b bVar) {
        bVar.getClass();
        iconCompat.i = iconCompat.f665h.name();
        switch (iconCompat.f659a) {
            case -1:
                iconCompat.f662d = (Parcelable) iconCompat.f660b;
                break;
            case 1:
            case h.STRING_FIELD_NUMBER /* 5 */:
                iconCompat.f662d = (Parcelable) iconCompat.f660b;
                break;
            case 2:
                iconCompat.f661c = ((String) iconCompat.f660b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f661c = (byte[]) iconCompat.f660b;
                break;
            case h.LONG_FIELD_NUMBER /* 4 */:
            case h.STRING_SET_FIELD_NUMBER /* 6 */:
                iconCompat.f661c = iconCompat.f660b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i = iconCompat.f659a;
        if (-1 != i) {
            bVar.j(i, 1);
        }
        byte[] bArr = iconCompat.f661c;
        if (bArr != null) {
            bVar.i(2);
            Parcel parcel = ((c) bVar).f8769e;
            parcel.writeInt(bArr.length);
            parcel.writeByteArray(bArr);
        }
        Parcelable parcelable = iconCompat.f662d;
        if (parcelable != null) {
            bVar.k(parcelable, 3);
        }
        int i10 = iconCompat.f663e;
        if (i10 != 0) {
            bVar.j(i10, 4);
        }
        int i11 = iconCompat.f;
        if (i11 != 0) {
            bVar.j(i11, 5);
        }
        ColorStateList colorStateList = iconCompat.f664g;
        if (colorStateList != null) {
            bVar.k(colorStateList, 6);
        }
        String str = iconCompat.i;
        if (str != null) {
            bVar.i(7);
            ((c) bVar).f8769e.writeString(str);
        }
        String str2 = iconCompat.f666j;
        if (str2 != null) {
            bVar.i(8);
            ((c) bVar).f8769e.writeString(str2);
        }
    }
}
