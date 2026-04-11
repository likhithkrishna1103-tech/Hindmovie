package ic;

import android.text.TextUtils;
import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;
import com.playz.tv.app.ProApplication;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements View.OnClickListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f6498u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f6499v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f6500w;

    public /* synthetic */ d(Object obj, int i, Object obj2) {
        this.f6498u = i;
        this.f6499v = obj;
        this.f6500w = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        switch (this.f6498u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                g gVar = (g) this.f6499v;
                oc.c cVar = (oc.c) this.f6500w;
                ProApplication proApplication = gVar.f6507e;
                proApplication.H = cVar.f9520g;
                proApplication.A = proApplication.B;
                lc.h.S(gVar.f, cVar.f, cVar.f9517c, cVar.f9515a, cVar.f9518d.equals("custom"), gVar.f6506d);
                break;
            default:
                j jVar = (j) this.f6499v;
                oc.e eVar = (oc.e) this.f6500w;
                k kVar = jVar.G;
                ProApplication proApplication2 = kVar.f6521d;
                proApplication2.f3681y = proApplication2.f3682z;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(eVar.f9529d);
                if (TextUtils.isEmpty(eVar.f9530e)) {
                    str = "";
                } else {
                    str = " vs " + eVar.f9530e;
                }
                sb2.append(str);
                lc.h.S(kVar.f6522e, eVar.f9537n, eVar.f9532h, sb2.toString(), true, kVar.f6525j);
                break;
        }
    }
}
