package x3;

import f9.m2;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executors;
import l4.c0;
import v1.r1;
import y2.d0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements n, z7.b, d0 {
    @Override // x3.n
    public int b(v1.p pVar) {
        String str = pVar.f12946n;
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
        throw new IllegalArgumentException(q4.a.n("Unsupported MIME type: ", str));
    }

    @Override // x3.n
    public p c(v1.p pVar) {
        String str = pVar.f12946n;
        List list = pVar.f12949q;
        if (str != null) {
            switch (str) {
                case "application/dvbsubs":
                    return new z3.g(list);
                case "application/pgs":
                    return new b6.f(1);
                case "application/x-mp4-vtt":
                    return new pc.c(17);
                case "text/vtt":
                    return new c0(23);
                case "application/x-quicktime-tx3g":
                    return new e4.a(list);
                case "text/x-ssa":
                    return new b4.b(list);
                case "application/vobsub":
                    return new b6.f(list);
                case "application/x-subrip":
                    return new c4.a();
                case "application/ttml+xml":
                    return new d4.f();
            }
        }
        throw new IllegalArgumentException(q4.a.n("Unsupported MIME type: ", str));
    }

    @Override // x3.n
    public boolean e(v1.p pVar) {
        String str = pVar.f12946n;
        return Objects.equals(str, "text/x-ssa") || Objects.equals(str, "text/vtt") || Objects.equals(str, "application/x-mp4-vtt") || Objects.equals(str, "application/x-subrip") || Objects.equals(str, "application/x-quicktime-tx3g") || Objects.equals(str, "application/pgs") || Objects.equals(str, "application/vobsub") || Objects.equals(str, "application/dvbsubs") || Objects.equals(str, "application/ttml+xml");
    }

    @Override // qd.a
    public Object get() {
        return new m2(3, Executors.newSingleThreadExecutor());
    }

    @Override // y2.d0
    public /* synthetic */ void d() {
    }

    @Override // y2.d0
    public /* synthetic */ void f() {
    }

    @Override // y2.d0
    public /* synthetic */ void l() {
    }

    @Override // y2.d0
    public /* synthetic */ void a(r1 r1Var) {
    }
}
