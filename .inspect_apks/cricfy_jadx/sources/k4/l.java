package k4;

import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f7058a = 0;

    static {
        ua.m0.m("android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.DURATION", "android.media.metadata.ALBUM", "android.media.metadata.AUTHOR", "android.media.metadata.WRITER", "android.media.metadata.COMPOSER", "android.media.metadata.COMPILATION", "android.media.metadata.DATE", "android.media.metadata.YEAR", "android.media.metadata.GENRE", "android.media.metadata.TRACK_NUMBER", "android.media.metadata.NUM_TRACKS", "android.media.metadata.DISC_NUMBER", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.ART", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART", "android.media.metadata.ALBUM_ART_URI", "android.media.metadata.USER_RATING", "android.media.metadata.RATING", "android.media.metadata.DISPLAY_TITLE", "android.media.metadata.DISPLAY_SUBTITLE", "android.media.metadata.DISPLAY_DESCRIPTION", "android.media.metadata.DISPLAY_ICON", "android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.MEDIA_ID", "android.media.metadata.MEDIA_URI", "android.media.metadata.BT_FOLDER_TYPE", "android.media.metadata.ADVERTISEMENT", "android.media.metadata.DOWNLOAD_STATUS", "androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT");
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
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                return 4L;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                return 5L;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                return 6L;
            default:
                throw new IllegalArgumentException(l0.e.g(i, "Unrecognized FolderType: "));
        }
    }

    public static l4.r b(v1.j0 j0Var, String str, Uri uri, long j4, Bitmap bitmap) {
        Long l10;
        l4.q qVar = new l4.q();
        qVar.k("android.media.metadata.MEDIA_ID", str);
        CharSequence charSequence = j0Var.f12765a;
        Bundle bundle = j0Var.I;
        Integer num = j0Var.f12778p;
        Uri uri2 = j0Var.f12775m;
        if (charSequence != null) {
            qVar.l("android.media.metadata.TITLE", charSequence);
        }
        CharSequence charSequence2 = j0Var.f12769e;
        if (charSequence2 != null) {
            qVar.l("android.media.metadata.DISPLAY_TITLE", charSequence2);
        }
        CharSequence charSequence3 = j0Var.f;
        if (charSequence3 != null) {
            qVar.l("android.media.metadata.DISPLAY_SUBTITLE", charSequence3);
        }
        CharSequence charSequence4 = j0Var.f12770g;
        if (charSequence4 != null) {
            qVar.l("android.media.metadata.DISPLAY_DESCRIPTION", charSequence4);
        }
        CharSequence charSequence5 = j0Var.f12766b;
        if (charSequence5 != null) {
            qVar.l("android.media.metadata.ARTIST", charSequence5);
        }
        CharSequence charSequence6 = j0Var.f12767c;
        if (charSequence6 != null) {
            qVar.l("android.media.metadata.ALBUM", charSequence6);
        }
        CharSequence charSequence7 = j0Var.f12768d;
        if (charSequence7 != null) {
            qVar.l("android.media.metadata.ALBUM_ARTIST", charSequence7);
        }
        if (j0Var.f12782t != null) {
            qVar.i("android.media.metadata.YEAR", r7.intValue());
        }
        if (uri != null) {
            qVar.k("android.media.metadata.MEDIA_URI", uri.toString());
        }
        if (uri2 != null) {
            qVar.k("android.media.metadata.DISPLAY_ICON_URI", uri2.toString());
            qVar.k("android.media.metadata.ALBUM_ART_URI", uri2.toString());
            qVar.k("android.media.metadata.ART_URI", uri2.toString());
        }
        if (bitmap != null) {
            qVar.h("android.media.metadata.DISPLAY_ICON", bitmap);
            qVar.h("android.media.metadata.ALBUM_ART", bitmap);
        }
        if (num != null && num.intValue() != -1) {
            qVar.i("android.media.metadata.BT_FOLDER_TYPE", a(num.intValue()));
        }
        if (j4 == -9223372036854775807L && (l10 = j0Var.f12771h) != null) {
            j4 = l10.longValue();
        }
        if (j4 == -9223372036854775807L) {
            j4 = -1;
        }
        qVar.i("android.media.metadata.DURATION", j4);
        l4.l0 l0VarD = d(j0Var.i);
        if (l0VarD != null) {
            qVar.j("android.media.metadata.USER_RATING", l0VarD);
        }
        l4.l0 l0VarD2 = d(j0Var.f12772j);
        if (l0VarD2 != null) {
            qVar.j("android.media.metadata.RATING", l0VarD2);
        }
        if (j0Var.H != null) {
            qVar.i("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT", r6.intValue());
        }
        if (bundle != null) {
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj == null || (obj instanceof CharSequence)) {
                    qVar.l(str2, (CharSequence) obj);
                } else if ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long)) {
                    qVar.i(str2, ((Number) obj).longValue());
                }
            }
        }
        return new l4.r(qVar.f7752a);
    }

    public static v1.x0 c(l4.l0 l0Var) {
        if (l0Var == null) {
            return null;
        }
        float f = l0Var.f7739w;
        int i = l0Var.f7738v;
        switch (i) {
            case 1:
                if (l0Var.b()) {
                    return new v1.r(i == 1 && f == 1.0f);
                }
                return new v1.r();
            case 2:
                if (l0Var.b()) {
                    return new v1.a1(i == 2 && f == 1.0f);
                }
                return new v1.a1();
            case 3:
                return l0Var.b() ? new v1.y0(3, l0Var.a()) : new v1.y0(3);
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                return l0Var.b() ? new v1.y0(4, l0Var.a()) : new v1.y0(4);
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                return l0Var.b() ? new v1.y0(5, l0Var.a()) : new v1.y0(5);
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                if (!l0Var.b()) {
                    return new v1.o0();
                }
                if (i != 6 || !l0Var.b()) {
                    f = -1.0f;
                }
                return new v1.o0(f);
            default:
                return null;
        }
    }

    public static l4.l0 d(v1.x0 x0Var) {
        if (x0Var != null) {
            int iF = f(x0Var);
            if (!x0Var.b()) {
                switch (iF) {
                    case 1:
                    case 2:
                    case 3:
                    case g1.h.LONG_FIELD_NUMBER /* 4 */:
                    case g1.h.STRING_FIELD_NUMBER /* 5 */:
                    case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                        return new l4.l0(iF, -1.0f);
                    default:
                        return null;
                }
            }
            switch (iF) {
                case 1:
                    return new l4.l0(1, ((v1.r) x0Var).f12975c ? 1.0f : 0.0f);
                case 2:
                    return new l4.l0(2, ((v1.a1) x0Var).f12579c ? 1.0f : 0.0f);
                case 3:
                case g1.h.LONG_FIELD_NUMBER /* 4 */:
                case g1.h.STRING_FIELD_NUMBER /* 5 */:
                    return l4.l0.d(iF, ((v1.y0) x0Var).f13047c);
                case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                    return l4.l0.c(((v1.o0) x0Var).f12908b);
            }
        }
        return null;
    }

    public static int e(v1.c cVar) {
        l4.a cVar2 = Build.VERSION.SDK_INT >= 26 ? new l4.c(0, false) : new l4.a(0, false);
        AudioAttributes.Builder builder = (AudioAttributes.Builder) cVar2.f7697v;
        builder.setContentType(cVar.f12592a);
        builder.setFlags(cVar.f12593b);
        cVar2.G(cVar.f12594c);
        AudioAttributes audioAttributes = cVar2.p().f7699a;
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
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                return 4;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
            case 9:
            case 10:
                return 5;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
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

    public static int f(v1.x0 x0Var) {
        if (x0Var instanceof v1.r) {
            return 1;
        }
        if (x0Var instanceof v1.a1) {
            return 2;
        }
        if (!(x0Var instanceof v1.y0)) {
            return x0Var instanceof v1.o0 ? 6 : 0;
        }
        int i = ((v1.y0) x0Var).f13046b;
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
