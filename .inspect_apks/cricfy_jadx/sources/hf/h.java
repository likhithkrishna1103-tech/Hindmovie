package hf;

import androidx.media3.decoder.DecoderInputBuffer;
import fe.l;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import me.ibrahimsn.lib.SmoothBottomBar;
import pe.y0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h extends ge.h implements l {
    public final /* synthetic */ int D;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(int i, Object obj, Class cls, String str, String str2, int i10, int i11, int i12) {
        super(i, obj, cls, str, str2, i10, i11);
        this.D = i12;
    }

    @Override // fe.l
    public final Object a(Object obj) {
        int i = this.D;
        rd.l lVar = rd.l.f11003a;
        Object obj2 = this.f5243w;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int iIntValue = ((Number) obj).intValue();
                int i10 = SmoothBottomBar.f8469c0;
                ((SmoothBottomBar) obj2).b(iIntValue);
                return lVar;
            case 1:
                ((y0) obj2).l((Throwable) obj);
                return lVar;
            default:
                ge.i.e((Set) obj, "p0");
                w4.g gVar = (w4.g) obj2;
                ReentrantLock reentrantLock = gVar.f13939d;
                reentrantLock.lock();
                try {
                    List listR0 = sd.j.r0(gVar.f13938c.values());
                    reentrantLock.unlock();
                    Iterator it = listR0.iterator();
                    if (!it.hasNext()) {
                        return lVar;
                    }
                    ((w4.l) it.next()).getClass();
                    throw null;
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
        }
    }
}
