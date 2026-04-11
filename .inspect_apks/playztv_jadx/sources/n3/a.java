package n3;

import androidx.media3.decoder.DecoderInputBuffer;
import b1.j;
import com.bumptech.glide.d;
import p1.i0;
import p1.k0;
import p1.q;
import q1.c;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8685b;

    public a(String str, String str2) {
        this.f8684a = d.Y(str);
        this.f8685b = str2;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // p1.k0
    public final void a(i0 i0Var) {
        String str = this.f8684a;
        str.getClass();
        byte b10 = -1;
        switch (str.hashCode()) {
            case -1935137620:
                if (str.equals("TOTALTRACKS")) {
                    b10 = 0;
                }
                break;
            case -215998278:
                if (str.equals("TOTALDISCS")) {
                    b10 = 1;
                }
                break;
            case -113312716:
                if (str.equals("TRACKNUMBER")) {
                    b10 = 2;
                }
                break;
            case 62359119:
                if (str.equals("ALBUM")) {
                    b10 = 3;
                }
                break;
            case 67703139:
                if (str.equals("GENRE")) {
                    b10 = 4;
                }
                break;
            case 79833656:
                if (str.equals("TITLE")) {
                    b10 = 5;
                }
                break;
            case 428414940:
                if (str.equals("DESCRIPTION")) {
                    b10 = 6;
                }
                break;
            case 993300766:
                if (str.equals("DISCNUMBER")) {
                    b10 = 7;
                }
                break;
            case 1746739798:
                if (str.equals("ALBUMARTIST")) {
                    b10 = 8;
                }
                break;
            case 1939198791:
                if (str.equals("ARTIST")) {
                    b10 = 9;
                }
                break;
        }
        String str2 = this.f8685b;
        switch (b10) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Integer numU = c.U(str2);
                if (numU != null) {
                    i0Var.f9797o = numU;
                }
                break;
            case 1:
                Integer numU2 = c.U(str2);
                if (numU2 != null) {
                    i0Var.C = numU2;
                }
                break;
            case 2:
                Integer numU3 = c.U(str2);
                if (numU3 != null) {
                    i0Var.f9796n = numU3;
                }
                break;
            case 3:
                i0Var.f9787c = str2;
                break;
            case j.LONG_FIELD_NUMBER /* 4 */:
                i0Var.D = str2;
                break;
            case j.STRING_FIELD_NUMBER /* 5 */:
                i0Var.f9785a = str2;
                break;
            case j.STRING_SET_FIELD_NUMBER /* 6 */:
                i0Var.f9790g = str2;
                break;
            case j.DOUBLE_FIELD_NUMBER /* 7 */:
                Integer numU4 = c.U(str2);
                if (numU4 != null) {
                    i0Var.B = numU4;
                }
                break;
            case 8:
                i0Var.f9788d = str2;
                break;
            case 9:
                i0Var.f9786b = str2;
                break;
        }
    }

    @Override // p1.k0
    public final /* synthetic */ q b() {
        return null;
    }

    @Override // p1.k0
    public final /* synthetic */ byte[] c() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f8684a.equals(aVar.f8684a) && this.f8685b.equals(aVar.f8685b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f8685b.hashCode() + e6.j.h(527, 31, this.f8684a);
    }

    public final String toString() {
        return "VC: " + this.f8684a + "=" + this.f8685b;
    }
}
