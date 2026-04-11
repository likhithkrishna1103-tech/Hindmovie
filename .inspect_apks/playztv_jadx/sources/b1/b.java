package b1;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends be.i implements ae.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Context f1711v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ c f1712w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, c cVar) {
        super(0);
        this.f1711v = context;
        this.f1712w = cVar;
    }

    @Override // ae.a
    public final Object b() {
        Context context = this.f1711v;
        be.h.d(context, "applicationContext");
        String str = this.f1712w.f1713a;
        be.h.e(str, "name");
        String strH = be.h.h(".preferences_pb", str);
        be.h.e(strH, "fileName");
        return new File(context.getApplicationContext().getFilesDir(), be.h.h(strH, "datastore/"));
    }
}
