package ie;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements ae.l {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f6613u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ String f6614v;

    public /* synthetic */ f(String str, int i) {
        this.f6613u = i;
        this.f6614v = str;
    }

    @Override // ae.l
    public final Object a(Object obj) throws Exception {
        switch (this.f6613u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                String str = (String) obj;
                be.h.e(str, "it");
                boolean zU = e.U(str);
                String str2 = this.f6614v;
                return zU ? str.length() < str2.length() ? str2 : str : str2.concat(str);
            default:
                y4.c cVarE0 = ((y4.a) obj).e0("SELECT * FROM fav_channels WHERE name = ? LIMIT 1");
                String str3 = this.f6614v;
                try {
                    if (str3 == null) {
                        cVarE0.b(1);
                    } else {
                        cVarE0.i(str3, 1);
                    }
                    int iR = android.support.v4.media.session.b.r(cVarE0, "id");
                    int iR2 = android.support.v4.media.session.b.r(cVarE0, "name");
                    int iR3 = android.support.v4.media.session.b.r(cVarE0, "image");
                    int iR4 = android.support.v4.media.session.b.r(cVarE0, "link");
                    int iR5 = android.support.v4.media.session.b.r(cVarE0, "playlist");
                    rc.c cVar = null;
                    String strJ = null;
                    if (cVarE0.W()) {
                        String strJ2 = cVarE0.isNull(iR2) ? null : cVarE0.j(iR2);
                        String strJ3 = cVarE0.isNull(iR3) ? null : cVarE0.j(iR3);
                        String strJ4 = cVarE0.isNull(iR4) ? null : cVarE0.j(iR4);
                        if (!cVarE0.isNull(iR5)) {
                            strJ = cVarE0.j(iR5);
                        }
                        rc.c cVar2 = new rc.c(strJ2, strJ3, strJ4, strJ);
                        cVar2.f11563a = (int) cVarE0.getLong(iR);
                        cVar = cVar2;
                    }
                    cVarE0.close();
                    return cVar;
                } catch (Throwable th) {
                    cVarE0.close();
                    throw th;
                }
        }
    }
}
