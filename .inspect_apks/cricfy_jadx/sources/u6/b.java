package u6;

import com.bumptech.glide.l;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f12259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File[] f12260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final File[] f12261d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f12262e;
    public l f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ c f12263g;

    public b(c cVar, String str) {
        this.f12263g = cVar;
        this.f12258a = str;
        int i = cVar.B;
        File file = cVar.f12264v;
        this.f12259b = new long[i];
        this.f12260c = new File[i];
        this.f12261d = new File[i];
        StringBuilder sb = new StringBuilder(str);
        sb.append('.');
        int length = sb.length();
        for (int i10 = 0; i10 < i; i10++) {
            sb.append(i10);
            this.f12260c[i10] = new File(file, sb.toString());
            sb.append(".tmp");
            this.f12261d[i10] = new File(file, sb.toString());
            sb.setLength(length);
        }
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        for (long j4 : this.f12259b) {
            sb.append(' ');
            sb.append(j4);
        }
        return sb.toString();
    }
}
