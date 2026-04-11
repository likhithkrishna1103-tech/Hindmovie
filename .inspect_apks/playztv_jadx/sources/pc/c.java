package pc;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements l {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f10313u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ String f10314v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ String f10315w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ String f10316x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ ue.m f10317y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ i f10318z;

    public /* synthetic */ c(String str, String str2, String str3, ue.m mVar, i iVar, int i) {
        this.f10313u = i;
        this.f10314v = str;
        this.f10315w = str2;
        this.f10316x = str3;
        this.f10317y = mVar;
        this.f10318z = iVar;
    }

    @Override // pc.l
    public final void f(String str, boolean z2) {
        switch (this.f10313u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                pb.c cVar = new pb.c(14);
                cVar.a("source", this.f10314v);
                cVar.a("type", this.f10315w);
                cVar.a("data", str);
                ue.k kVar = new ue.k((ArrayList) cVar.f10310v, (ArrayList) cVar.f10311w);
                String str2 = this.f10316x;
                ga.b.D(null, str2, true, kVar, this.f10317y, new b2.b(str2, 18, this.f10318z));
                break;
            default:
                pb.c cVar2 = new pb.c(14);
                cVar2.a("source", this.f10314v);
                cVar2.a("type", this.f10315w);
                cVar2.a("status", str);
                ga.b.D(null, this.f10316x, true, new ue.k((ArrayList) cVar2.f10310v, (ArrayList) cVar2.f10311w), this.f10317y, new d(this.f10318z, 0));
                break;
        }
    }
}
