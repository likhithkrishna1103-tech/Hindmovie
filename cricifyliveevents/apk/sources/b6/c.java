package b6;

import androidx.media3.decoder.DecoderInputBuffer;
import fc.j;
import fe.l;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements l {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f1793v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f1794w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f1795x;

    public /* synthetic */ c(int i, Object obj, Object obj2) {
        this.f1793v = i;
        this.f1794w = obj;
        this.f1795x = obj2;
    }

    @Override // fe.l
    public final Object a(Object obj) throws Exception {
        switch (this.f1793v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                f fVar = (f) this.f1794w;
                i iVar = (i) this.f1795x;
                ((e) fVar.f1802y).B((c5.a) obj, iVar);
                return null;
            case 1:
                f fVar2 = (f) this.f1794w;
                h hVar = (h) this.f1795x;
                ((e) fVar2.f1803z).B((c5.a) obj, hVar);
                return null;
            case 2:
                f fVar3 = (f) this.f1794w;
                g gVar = (g) this.f1795x;
                ((e) fVar3.f1801x).B((c5.a) obj, gVar);
                return null;
            case 3:
                j jVar = (j) this.f1794w;
                String str = (String) this.f1795x;
                h1.b bVar = (h1.b) obj;
                jVar.getClass();
                bVar.d(j.f4558d, str);
                jVar.h(bVar, str);
                return null;
            default:
                qe.c cVar = (qe.c) this.f1794w;
                cVar.f10807x.removeCallbacks((k8.j) this.f1795x);
                return rd.l.f11003a;
        }
    }
}
