package zc;

import a5.l;
import androidx.media3.decoder.DecoderInputBuffer;
import be.h;
import r4.t;
import r4.w;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f14943d = 1;

    public /* synthetic */ a(t tVar) {
        super(tVar);
    }

    @Override // r4.w
    public final String c() {
        switch (this.f14943d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return "INSERT OR ABORT INTO `requests` (`_id`,`_namespace`,`_url`,`_file`,`_group`,`_priority`,`_headers`,`_written_bytes`,`_total_bytes`,`_status`,`_error`,`_network_type`,`_created`,`_tag`,`_enqueue_action`,`_identifier`,`_download_on_enqueue`,`_extras`,`_auto_retry_max_attempts`,`_auto_retry_attempts`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            default:
                return "DELETE FROM requests";
        }
    }

    public void e(l lVar, Object obj) {
        e eVar = (e) obj;
        lVar.N(1, eVar.f14950u);
        lVar.V(eVar.f14951v, 2);
        lVar.V(eVar.f14952w, 3);
        lVar.V(eVar.f14953x, 4);
        lVar.N(5, eVar.f14954y);
        h.e(eVar.f14955z, "priority");
        lVar.N(6, r0.f14677u);
        lVar.V(ua.c.f(eVar.A), 7);
        lVar.N(8, eVar.B);
        lVar.N(9, eVar.C);
        h.e(eVar.D, "status");
        lVar.N(10, r0.f14692u);
        h.e(eVar.E, "error");
        lVar.N(11, r0.f14653u);
        h.e(eVar.F, "networkType");
        lVar.N(12, r0.f14671u);
        lVar.N(13, eVar.G);
        String str = eVar.H;
        if (str == null) {
            lVar.b(14);
        } else {
            lVar.V(str, 14);
        }
        h.e(eVar.I, "enqueueAction");
        lVar.N(15, r0.f14645u);
        lVar.N(16, eVar.J);
        lVar.N(17, eVar.K ? 1L : 0L);
        lVar.V(ua.c.c(eVar.L), 18);
        lVar.N(19, eVar.M);
        lVar.N(20, eVar.N);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c cVar, t tVar) {
        super(tVar);
        h.e(tVar, "database");
    }
}
