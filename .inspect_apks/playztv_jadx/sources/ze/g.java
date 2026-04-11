package ze;

import hf.h;
import hf.q;
import java.util.regex.Pattern;
import ue.v;
import ue.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends z {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f14974u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f14975v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final q f14976w;

    public g(String str, long j5, q qVar) {
        this.f14974u = str;
        this.f14975v = j5;
        this.f14976w = qVar;
    }

    @Override // ue.z
    public final long a() {
        return this.f14975v;
    }

    @Override // ue.z
    public final ue.q d() {
        String str = this.f14974u;
        if (str == null) {
            return null;
        }
        Pattern pattern = ue.q.f13015c;
        try {
            return v.i(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @Override // ue.z
    public final h v() {
        return this.f14976w;
    }
}
