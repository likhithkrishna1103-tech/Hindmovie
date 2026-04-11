package c;

import android.content.res.Resources;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e0 implements ae.l {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f2161u;

    public /* synthetic */ e0(int i) {
        this.f2161u = i;
    }

    @Override // ae.l
    public final Object a(Object obj) throws Exception {
        switch (this.f2161u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Resources resources = (Resources) obj;
                be.h.e(resources, "resources");
                return Boolean.valueOf((resources.getConfiguration().uiMode & 48) == 32);
            case 1:
                rd.f fVar = (rd.f) obj;
                if (fVar instanceof ke.r) {
                    return (ke.r) fVar;
                }
                return null;
            case 2:
                y4.c cVar = (y4.c) obj;
                be.h.e(cVar, "it");
                return Boolean.valueOf(cVar.W());
            case 3:
                y4.c cVar2 = (y4.c) obj;
                be.h.e(cVar2, "statement");
                pd.i iVar = new pd.i();
                while (cVar2.W()) {
                    iVar.add(Integer.valueOf((int) cVar2.getLong(0)));
                }
                return cf.d.c(iVar);
            default:
                y4.c cVarE0 = ((y4.a) obj).e0("SELECT * FROM fav_channels");
                try {
                    int iR = android.support.v4.media.session.b.r(cVarE0, "id");
                    int iR2 = android.support.v4.media.session.b.r(cVarE0, "name");
                    int iR3 = android.support.v4.media.session.b.r(cVarE0, "image");
                    int iR4 = android.support.v4.media.session.b.r(cVarE0, "link");
                    int iR5 = android.support.v4.media.session.b.r(cVarE0, "playlist");
                    ArrayList arrayList = new ArrayList();
                    while (cVarE0.W()) {
                        String strJ = null;
                        String strJ2 = cVarE0.isNull(iR2) ? null : cVarE0.j(iR2);
                        String strJ3 = cVarE0.isNull(iR3) ? null : cVarE0.j(iR3);
                        String strJ4 = cVarE0.isNull(iR4) ? null : cVarE0.j(iR4);
                        if (!cVarE0.isNull(iR5)) {
                            strJ = cVarE0.j(iR5);
                        }
                        rc.c cVar3 = new rc.c(strJ2, strJ3, strJ4, strJ);
                        cVar3.f11563a = (int) cVarE0.getLong(iR);
                        arrayList.add(cVar3);
                        break;
                    }
                    return arrayList;
                } finally {
                    cVarE0.close();
                }
        }
    }
}
