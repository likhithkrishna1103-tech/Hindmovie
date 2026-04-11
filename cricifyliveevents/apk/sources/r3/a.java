package r3;

import android.support.v4.media.session.b;
import androidx.media3.decoder.DecoderInputBuffer;
import com.bumptech.glide.d;
import g1.h;
import l0.e;
import v1.i0;
import v1.k0;
import v1.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10850b;

    public a(String str, String str2) {
        this.f10849a = b.P(str);
        this.f10850b = str2;
    }

    @Override // v1.k0
    public final /* synthetic */ p a() {
        return null;
    }

    @Override // v1.k0
    public final /* synthetic */ byte[] b() {
        return null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // v1.k0
    public final void c(i0 i0Var) {
        String str = this.f10849a;
        str.getClass();
        byte b8 = -1;
        switch (str.hashCode()) {
            case -1935137620:
                if (str.equals("TOTALTRACKS")) {
                    b8 = 0;
                }
                break;
            case -215998278:
                if (str.equals("TOTALDISCS")) {
                    b8 = 1;
                }
                break;
            case -113312716:
                if (str.equals("TRACKNUMBER")) {
                    b8 = 2;
                }
                break;
            case 62359119:
                if (str.equals("ALBUM")) {
                    b8 = 3;
                }
                break;
            case 67703139:
                if (str.equals("GENRE")) {
                    b8 = 4;
                }
                break;
            case 79833656:
                if (str.equals("TITLE")) {
                    b8 = 5;
                }
                break;
            case 428414940:
                if (str.equals("DESCRIPTION")) {
                    b8 = 6;
                }
                break;
            case 993300766:
                if (str.equals("DISCNUMBER")) {
                    b8 = 7;
                }
                break;
            case 1746739798:
                if (str.equals("ALBUMARTIST")) {
                    b8 = 8;
                }
                break;
            case 1939198791:
                if (str.equals("ARTIST")) {
                    b8 = 9;
                }
                break;
        }
        String str2 = this.f10850b;
        switch (b8) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Integer numF = d.F(str2);
                if (numF != null) {
                    i0Var.f12730o = numF;
                }
                break;
            case 1:
                Integer numF2 = d.F(str2);
                if (numF2 != null) {
                    i0Var.C = numF2;
                }
                break;
            case 2:
                Integer numF3 = d.F(str2);
                if (numF3 != null) {
                    i0Var.f12729n = numF3;
                }
                break;
            case 3:
                i0Var.f12720c = str2;
                break;
            case h.LONG_FIELD_NUMBER /* 4 */:
                i0Var.D = str2;
                break;
            case h.STRING_FIELD_NUMBER /* 5 */:
                i0Var.f12718a = str2;
                break;
            case h.STRING_SET_FIELD_NUMBER /* 6 */:
                i0Var.f12723g = str2;
                break;
            case h.DOUBLE_FIELD_NUMBER /* 7 */:
                Integer numF4 = d.F(str2);
                if (numF4 != null) {
                    i0Var.B = numF4;
                }
                break;
            case h.BYTES_FIELD_NUMBER /* 8 */:
                i0Var.f12721d = str2;
                break;
            case 9:
                i0Var.f12719b = str2;
                break;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f10849a.equals(aVar.f10849a) && this.f10850b.equals(aVar.f10850b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f10850b.hashCode() + e.e(527, 31, this.f10849a);
    }

    public final String toString() {
        return "VC: " + this.f10849a + "=" + this.f10850b;
    }
}
