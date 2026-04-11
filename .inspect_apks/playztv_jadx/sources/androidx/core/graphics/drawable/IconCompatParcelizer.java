package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.decoder.DecoderInputBuffer;
import b1.j;
import i5.b;
import i5.c;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class IconCompatParcelizer {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static IconCompat read(b bVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f985a = bVar.f(iconCompat.f985a, 1);
        byte[] bArr = iconCompat.f987c;
        if (bVar.e(2)) {
            Parcel parcel = ((c) bVar).f6370e;
            int i = parcel.readInt();
            if (i < 0) {
                bArr = null;
            } else {
                byte[] bArr2 = new byte[i];
                parcel.readByteArray(bArr2);
                bArr = bArr2;
            }
        }
        iconCompat.f987c = bArr;
        iconCompat.f988d = bVar.g(iconCompat.f988d, 3);
        iconCompat.f989e = bVar.f(iconCompat.f989e, 4);
        iconCompat.f = bVar.f(iconCompat.f, 5);
        iconCompat.f990g = (ColorStateList) bVar.g(iconCompat.f990g, 6);
        String string = iconCompat.i;
        if (bVar.e(7)) {
            string = ((c) bVar).f6370e.readString();
        }
        iconCompat.i = string;
        String string2 = iconCompat.f992j;
        if (bVar.e(8)) {
            string2 = ((c) bVar).f6370e.readString();
        }
        iconCompat.f992j = string2;
        iconCompat.f991h = PorterDuff.Mode.valueOf(iconCompat.i);
        switch (iconCompat.f985a) {
            case -1:
                Parcelable parcelable = iconCompat.f988d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                iconCompat.f986b = parcelable;
                return iconCompat;
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
            default:
                return iconCompat;
            case 1:
            case j.STRING_FIELD_NUMBER /* 5 */:
                Parcelable parcelable2 = iconCompat.f988d;
                if (parcelable2 != null) {
                    iconCompat.f986b = parcelable2;
                    return iconCompat;
                }
                byte[] bArr3 = iconCompat.f987c;
                iconCompat.f986b = bArr3;
                iconCompat.f985a = 3;
                iconCompat.f989e = 0;
                iconCompat.f = bArr3.length;
                return iconCompat;
            case 2:
            case j.LONG_FIELD_NUMBER /* 4 */:
            case j.STRING_SET_FIELD_NUMBER /* 6 */:
                String str = new String(iconCompat.f987c, Charset.forName("UTF-16"));
                iconCompat.f986b = str;
                if (iconCompat.f985a == 2 && iconCompat.f992j == null) {
                    iconCompat.f992j = str.split(":", -1)[0];
                }
                return iconCompat;
            case 3:
                iconCompat.f986b = iconCompat.f987c;
                return iconCompat;
        }
    }

    public static void write(IconCompat iconCompat, b bVar) {
        bVar.getClass();
        iconCompat.i = iconCompat.f991h.name();
        switch (iconCompat.f985a) {
            case -1:
                iconCompat.f988d = (Parcelable) iconCompat.f986b;
                break;
            case 1:
            case j.STRING_FIELD_NUMBER /* 5 */:
                iconCompat.f988d = (Parcelable) iconCompat.f986b;
                break;
            case 2:
                iconCompat.f987c = ((String) iconCompat.f986b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f987c = (byte[]) iconCompat.f986b;
                break;
            case j.LONG_FIELD_NUMBER /* 4 */:
            case j.STRING_SET_FIELD_NUMBER /* 6 */:
                iconCompat.f987c = iconCompat.f986b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i = iconCompat.f985a;
        if (-1 != i) {
            bVar.j(i, 1);
        }
        byte[] bArr = iconCompat.f987c;
        if (bArr != null) {
            bVar.i(2);
            Parcel parcel = ((c) bVar).f6370e;
            parcel.writeInt(bArr.length);
            parcel.writeByteArray(bArr);
        }
        Parcelable parcelable = iconCompat.f988d;
        if (parcelable != null) {
            bVar.k(parcelable, 3);
        }
        int i10 = iconCompat.f989e;
        if (i10 != 0) {
            bVar.j(i10, 4);
        }
        int i11 = iconCompat.f;
        if (i11 != 0) {
            bVar.j(i11, 5);
        }
        ColorStateList colorStateList = iconCompat.f990g;
        if (colorStateList != null) {
            bVar.k(colorStateList, 6);
        }
        String str = iconCompat.i;
        if (str != null) {
            bVar.i(7);
            ((c) bVar).f6370e.writeString(str);
        }
        String str2 = iconCompat.f992j;
        if (str2 != null) {
            bVar.i(8);
            ((c) bVar).f6370e.writeString(str2);
        }
    }
}
