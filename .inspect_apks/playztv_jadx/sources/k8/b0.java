package k8;

import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.a9;
import com.google.android.gms.internal.measurement.b9;
import com.google.android.gms.internal.measurement.c7;
import com.google.android.gms.internal.measurement.e7;
import com.google.android.gms.internal.measurement.e9;
import com.google.android.gms.internal.measurement.f9;
import com.google.android.gms.internal.measurement.g9;
import com.google.android.gms.internal.measurement.h9;
import com.google.android.gms.internal.measurement.l9;
import com.google.android.gms.internal.measurement.n8;
import com.google.android.gms.internal.measurement.n9;
import com.google.android.gms.internal.measurement.p8;
import com.google.android.gms.internal.measurement.v7;
import com.google.android.gms.internal.measurement.x6;
import com.google.android.gms.internal.measurement.x7;
import com.google.android.gms.internal.measurement.y8;
import com.google.android.gms.internal.measurement.z6;
import com.google.android.gms.internal.measurement.z8;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b0 implements e0, l6.c0, l7.a, m.v, s2.n, t3.k, o8.g {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7086u;

    public /* synthetic */ b0(int i) {
        this.f7086u = i;
    }

    public static void h(y4.c cVar, Object obj) {
        rc.c cVar2 = (rc.c) obj;
        cVar.k(cVar2.f11563a);
        String str = cVar2.f11564b;
        if (str == null) {
            cVar.b(2);
        } else {
            cVar.i(str, 2);
        }
        String str2 = cVar2.f11565c;
        if (str2 == null) {
            cVar.b(3);
        } else {
            cVar.i(str2, 3);
        }
        String str3 = cVar2.f11566d;
        if (str3 == null) {
            cVar.b(4);
        } else {
            cVar.i(str3, 4);
        }
        String str4 = cVar2.f11567e;
        if (str4 == null) {
            cVar.b(5);
        } else {
            cVar.i(str4, 5);
        }
    }

    @Override // k8.e0
    public Object a() {
        switch (this.f7086u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                x6.f3236v.get();
                return Integer.valueOf((int) ((Long) z6.f3276m.a()).longValue());
            case 1:
                y8.f3250v.get();
                return (String) a9.f.a();
            case 2:
                y8.f3250v.get();
                return Integer.valueOf((int) ((Long) a9.f2893d.a()).longValue());
            case 3:
                x6.f3236v.get();
                return Integer.valueOf((int) ((Long) z6.f3282s.a()).longValue());
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                x6.f3236v.get();
                Long l10 = (Long) z6.M.a();
                l10.getClass();
                return l10;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                x6.f3236v.get();
                return (String) z6.K.a();
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                x6.f3236v.get();
                Long l11 = (Long) z6.i.a();
                l11.getClass();
                return l11;
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                e9.f2961v.get();
                Boolean bool = (Boolean) g9.f3024c.a();
                bool.getClass();
                return bool;
            case 8:
                x6.f3236v.get();
                return Integer.valueOf((int) ((Long) z6.f3283t.a()).longValue());
            case 9:
                z8.f3290v.get();
                Boolean bool2 = (Boolean) b9.f2906a.a();
                bool2.getClass();
                return bool2;
            case 10:
                v7.f3218v.get();
                Boolean bool3 = (Boolean) x7.f3240c.a();
                bool3.getClass();
                return bool3;
            case 11:
                c7.f2921v.get();
                return Integer.valueOf((int) ((Long) e7.f2960a.a()).longValue());
            case 12:
                f9.f2975v.get();
                Boolean bool4 = (Boolean) h9.f3042a.a();
                bool4.getClass();
                return bool4;
            case 13:
                l9.f3091v.get();
                Boolean bool5 = (Boolean) n9.f3129c.a();
                bool5.getClass();
                return bool5;
            default:
                n8.f3125v.get();
                Boolean bool6 = (Boolean) p8.f3155a.a();
                bool6.getClass();
                return bool6;
        }
    }

    @Override // t3.k
    public boolean d(p1.q qVar) {
        String str = qVar.f10023n;
        return Objects.equals(str, "text/x-ssa") || Objects.equals(str, "text/vtt") || Objects.equals(str, "application/x-mp4-vtt") || Objects.equals(str, "application/x-subrip") || Objects.equals(str, "application/x-quicktime-tx3g") || Objects.equals(str, "application/pgs") || Objects.equals(str, "application/vobsub") || Objects.equals(str, "application/dvbsubs") || Objects.equals(str, "application/ttml+xml");
    }

    @Override // t3.k
    public int e(p1.q qVar) {
        String str = qVar.f10023n;
        if (str != null) {
            switch (str) {
                case "application/dvbsubs":
                case "application/pgs":
                case "application/x-mp4-vtt":
                    return 2;
                case "text/vtt":
                    return 1;
                case "application/x-quicktime-tx3g":
                    return 2;
                case "text/x-ssa":
                    return 1;
                case "application/vobsub":
                    return 2;
                case "application/x-subrip":
                case "application/ttml+xml":
                    return 1;
            }
        }
        throw new IllegalArgumentException(l4.a.m("Unsupported MIME type: ", str));
    }

    @Override // t3.k
    public t3.m f(p1.q qVar) {
        String str = qVar.f10023n;
        List list = qVar.f10026q;
        if (str != null) {
            switch (str) {
                case "application/dvbsubs":
                    return new v3.h(list);
                case "application/pgs":
                    return new ub.o(29);
                case "application/x-mp4-vtt":
                    return new wb.c(7);
                case "text/vtt":
                    return new com.google.android.gms.internal.measurement.k4(6);
                case "application/x-quicktime-tx3g":
                    return new a4.a(list);
                case "text/x-ssa":
                    return new x3.a(list);
                case "application/vobsub":
                    return new ub.o(list);
                case "application/x-subrip":
                    return new y3.a();
                case "application/ttml+xml":
                    return new z3.e();
            }
        }
        throw new IllegalArgumentException(l4.a.m("Unsupported MIME type: ", str));
    }

    @Override // l7.a
    public long g() {
        return System.currentTimeMillis();
    }

    @Override // l6.c0
    public void o(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
        mediaMetadataRetriever.setDataSource(new l6.b0((ByteBuffer) obj));
    }

    @Override // l6.c0
    public void q(MediaExtractor mediaExtractor, Object obj) throws IOException {
        mediaExtractor.setDataSource(new l6.b0((ByteBuffer) obj));
    }

    @Override // o8.g
    public o8.o r(Object obj) {
        return wa.t1.k(Boolean.TRUE);
    }

    @Override // m.v
    public boolean x(m.k kVar) {
        return false;
    }

    @Override // s2.n
    public void b() {
    }

    @Override // m.v
    public void c(m.k kVar, boolean z2) {
    }
}
