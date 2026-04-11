package dd;

import androidx.media3.decoder.DecoderInputBuffer;
import e5.j;
import ge.i;
import w4.t;
import w4.z;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f3669d = 0;

    public /* synthetic */ a(t tVar) {
        super(tVar);
    }

    @Override // w4.z
    public final String c() {
        switch (this.f3669d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return "INSERT OR ABORT INTO `requests` (`_id`,`_namespace`,`_url`,`_file`,`_group`,`_priority`,`_headers`,`_written_bytes`,`_total_bytes`,`_status`,`_error`,`_network_type`,`_created`,`_tag`,`_enqueue_action`,`_identifier`,`_download_on_enqueue`,`_extras`,`_auto_retry_max_attempts`,`_auto_retry_attempts`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            default:
                return "DELETE FROM requests";
        }
    }

    public void e(j jVar, Object obj) {
        e eVar = (e) obj;
        jVar.e(1, eVar.f3676v);
        jVar.n(2, eVar.f3677w);
        jVar.n(3, eVar.f3678x);
        jVar.n(4, eVar.f3679y);
        jVar.e(5, eVar.f3680z);
        i.e(eVar.A, "priority");
        jVar.e(6, r0.f2176v);
        jVar.n(7, fc.e.g(eVar.B));
        jVar.e(8, eVar.C);
        jVar.e(9, eVar.D);
        i.e(eVar.E, "status");
        jVar.e(10, r0.f2189v);
        i.e(eVar.F, "error");
        jVar.e(11, r0.f2154v);
        i.e(eVar.G, "networkType");
        jVar.e(12, r0.f2171v);
        jVar.e(13, eVar.H);
        String str = eVar.I;
        if (str == null) {
            jVar.b(14);
        } else {
            jVar.n(14, str);
        }
        i.e(eVar.J, "enqueueAction");
        jVar.e(15, r0.f2146v);
        jVar.e(16, eVar.K);
        jVar.e(17, eVar.L ? 1L : 0L);
        jVar.n(18, fc.e.c(eVar.M));
        jVar.e(19, eVar.N);
        jVar.e(20, eVar.O);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c cVar, t tVar) {
        super(tVar);
        i.e(tVar, "database");
    }
}
