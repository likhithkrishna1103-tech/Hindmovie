package tc;

import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import ic.o;
import pc.l;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements l, o {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f12459u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ g f12460v;

    public /* synthetic */ e(g gVar, int i) {
        this.f12459u = i;
        this.f12460v = gVar;
    }

    @Override // ic.o
    public void a(String str, String str2, String str3, String str4, int i, boolean z2) {
        g gVar = this.f12460v;
        gVar.f12470j = str;
        gVar.f12471k = str2;
        gVar.f12472l = str3;
        gVar.f12479s = i;
        gVar.f12473m = str4;
        gVar.f12477q = z2;
        gVar.f(str, str2, str3, str4, null);
    }

    @Override // pc.l
    public void f(String str, boolean z2) {
        switch (this.f12459u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                g gVar = this.f12460v;
                gVar.getClass();
                Log.e("Pro Api Data", str);
                if (!z2) {
                    gVar.f("https://pro.com", "pro", null, null, null);
                } else {
                    gVar.k(str, false);
                }
                break;
            default:
                g gVar2 = this.f12460v;
                if (!z2) {
                    gVar2.f("https://pro.com", "pro", null, null, null);
                } else {
                    gVar2.k(str, false);
                }
                break;
        }
    }
}
