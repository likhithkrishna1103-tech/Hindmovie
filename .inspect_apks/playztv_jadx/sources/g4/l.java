package g4;

import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f5102a = 0;

    static {
        aa.o0.t("android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.DURATION", "android.media.metadata.ALBUM", "android.media.metadata.AUTHOR", "android.media.metadata.WRITER", "android.media.metadata.COMPOSER", "android.media.metadata.COMPILATION", "android.media.metadata.DATE", "android.media.metadata.YEAR", "android.media.metadata.GENRE", "android.media.metadata.TRACK_NUMBER", "android.media.metadata.NUM_TRACKS", "android.media.metadata.DISC_NUMBER", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.ART", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART", "android.media.metadata.ALBUM_ART_URI", "android.media.metadata.USER_RATING", "android.media.metadata.RATING", "android.media.metadata.DISPLAY_TITLE", "android.media.metadata.DISPLAY_SUBTITLE", "android.media.metadata.DISPLAY_DESCRIPTION", "android.media.metadata.DISPLAY_ICON", "android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.MEDIA_ID", "android.media.metadata.MEDIA_URI", "android.media.metadata.BT_FOLDER_TYPE", "android.media.metadata.ADVERTISEMENT", "android.media.metadata.DOWNLOAD_STATUS", "androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT");
    }

    public static long a(int i) {
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return 0L;
            case 1:
                return 1L;
            case 2:
                return 2L;
            case 3:
                return 3L;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return 4L;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                return 5L;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                return 6L;
            default:
                throw new IllegalArgumentException(e6.j.l("Unrecognized FolderType: ", i));
        }
    }

    public static h4.o b(p1.j0 j0Var, String str, Uri uri, long j5, Bitmap bitmap) {
        Long l10;
        ec.a aVar = new ec.a();
        aVar.e("android.media.metadata.MEDIA_ID", str);
        CharSequence charSequence = j0Var.f9836a;
        Bundle bundle = j0Var.I;
        Integer num = j0Var.f9849p;
        Uri uri2 = j0Var.f9846m;
        if (charSequence != null) {
            aVar.f("android.media.metadata.TITLE", charSequence);
        }
        CharSequence charSequence2 = j0Var.f9840e;
        if (charSequence2 != null) {
            aVar.f("android.media.metadata.DISPLAY_TITLE", charSequence2);
        }
        CharSequence charSequence3 = j0Var.f;
        if (charSequence3 != null) {
            aVar.f("android.media.metadata.DISPLAY_SUBTITLE", charSequence3);
        }
        CharSequence charSequence4 = j0Var.f9841g;
        if (charSequence4 != null) {
            aVar.f("android.media.metadata.DISPLAY_DESCRIPTION", charSequence4);
        }
        CharSequence charSequence5 = j0Var.f9837b;
        if (charSequence5 != null) {
            aVar.f("android.media.metadata.ARTIST", charSequence5);
        }
        CharSequence charSequence6 = j0Var.f9838c;
        if (charSequence6 != null) {
            aVar.f("android.media.metadata.ALBUM", charSequence6);
        }
        CharSequence charSequence7 = j0Var.f9839d;
        if (charSequence7 != null) {
            aVar.f("android.media.metadata.ALBUM_ARTIST", charSequence7);
        }
        if (j0Var.f9853t != null) {
            aVar.c("android.media.metadata.YEAR", r7.intValue());
        }
        if (uri != null) {
            aVar.e("android.media.metadata.MEDIA_URI", uri.toString());
        }
        if (uri2 != null) {
            aVar.e("android.media.metadata.DISPLAY_ICON_URI", uri2.toString());
            aVar.e("android.media.metadata.ALBUM_ART_URI", uri2.toString());
            aVar.e("android.media.metadata.ART_URI", uri2.toString());
        }
        if (bitmap != null) {
            aVar.b("android.media.metadata.DISPLAY_ICON", bitmap);
            aVar.b("android.media.metadata.ALBUM_ART", bitmap);
        }
        if (num != null && num.intValue() != -1) {
            aVar.c("android.media.metadata.BT_FOLDER_TYPE", a(num.intValue()));
        }
        if (j5 == -9223372036854775807L && (l10 = j0Var.f9842h) != null) {
            j5 = l10.longValue();
        }
        if (j5 == -9223372036854775807L) {
            j5 = -1;
        }
        aVar.c("android.media.metadata.DURATION", j5);
        h4.i0 i0VarD = d(j0Var.i);
        if (i0VarD != null) {
            aVar.d("android.media.metadata.USER_RATING", i0VarD);
        }
        h4.i0 i0VarD2 = d(j0Var.f9843j);
        if (i0VarD2 != null) {
            aVar.d("android.media.metadata.RATING", i0VarD2);
        }
        if (j0Var.H != null) {
            aVar.c("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT", r6.intValue());
        }
        if (bundle != null) {
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj == null || (obj instanceof CharSequence)) {
                    aVar.f(str2, (CharSequence) obj);
                } else if ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long)) {
                    aVar.c(str2, ((Number) obj).longValue());
                }
            }
        }
        return new h4.o(aVar.f4640a);
    }

    public static p1.x0 c(h4.i0 i0Var) {
        if (i0Var == null) {
            return null;
        }
        float f = i0Var.f5819v;
        int i = i0Var.f5818u;
        switch (i) {
            case 1:
                if (i0Var.b()) {
                    return new p1.s(i == 1 && f == 1.0f);
                }
                return new p1.s();
            case 2:
                if (i0Var.b()) {
                    return new p1.a1(i == 2 && f == 1.0f);
                }
                return new p1.a1();
            case 3:
                return i0Var.b() ? new p1.y0(3, i0Var.a()) : new p1.y0(3);
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return i0Var.b() ? new p1.y0(4, i0Var.a()) : new p1.y0(4);
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                return i0Var.b() ? new p1.y0(5, i0Var.a()) : new p1.y0(5);
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                if (!i0Var.b()) {
                    return new p1.o0();
                }
                if (i != 6 || !i0Var.b()) {
                    f = -1.0f;
                }
                return new p1.o0(f);
            default:
                return null;
        }
    }

    public static h4.i0 d(p1.x0 x0Var) {
        if (x0Var != null) {
            int iF = f(x0Var);
            if (!x0Var.b()) {
                switch (iF) {
                    case 1:
                    case 2:
                    case 3:
                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                    case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                        return new h4.i0(iF, -1.0f);
                    default:
                        return null;
                }
            }
            switch (iF) {
                case 1:
                    return new h4.i0(1, ((p1.s) x0Var).f10055c ? 1.0f : 0.0f);
                case 2:
                    return new h4.i0(2, ((p1.a1) x0Var).f9643c ? 1.0f : 0.0f);
                case 3:
                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                    return h4.i0.d(iF, ((p1.y0) x0Var).f10112c);
                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                    return h4.i0.c(((p1.o0) x0Var).f9955b);
            }
        }
        return null;
    }

    public static int e(p1.d dVar) {
        u5.c bVar = Build.VERSION.SDK_INT >= 26 ? new h4.b(18) : new u5.c(18);
        AudioAttributes.Builder builder = (AudioAttributes.Builder) bVar.f12782v;
        builder.setContentType(dVar.f9688a);
        builder.setFlags(dVar.f9689b);
        bVar.o(dVar.f9690c);
        AudioAttributes audioAttributes = bVar.a().f5788a;
        audioAttributes.getClass();
        int flags = audioAttributes.getFlags();
        int usage = audioAttributes.getUsage();
        if ((flags & 1) == 1) {
            return 7;
        }
        if ((flags & 4) == 4) {
            return 6;
        }
        switch (usage) {
            case 2:
                return 0;
            case 3:
                return 8;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return 4;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
            case 8:
            case 9:
            case 10:
                return 5;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                return 2;
            case 11:
                return 10;
            case 12:
            default:
                return 3;
            case 13:
                return 1;
        }
    }

    public static int f(p1.x0 x0Var) {
        if (x0Var instanceof p1.s) {
            return 1;
        }
        if (x0Var instanceof p1.a1) {
            return 2;
        }
        if (!(x0Var instanceof p1.y0)) {
            return x0Var instanceof p1.o0 ? 6 : 0;
        }
        int i = ((p1.y0) x0Var).f10111b;
        int i10 = 3;
        if (i != 3) {
            i10 = 4;
            if (i != 4) {
                i10 = 5;
                if (i != 5) {
                    return 0;
                }
            }
        }
        return i10;
    }
}
