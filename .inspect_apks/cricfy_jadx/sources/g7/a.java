package g7;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.InputStream;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements x6.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f5165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f5166c;

    public /* synthetic */ a(int i, Object obj, Object obj2) {
        this.f5164a = i;
        this.f5165b = obj;
        this.f5166c = obj2;
    }

    @Override // x6.j
    public final boolean a(Object obj, x6.h hVar) {
        switch (this.f5164a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((x6.j) this.f5165b).a(obj, hVar);
            case 1:
                return "android.resource".equals(((Uri) obj).getScheme());
            default:
                ((p) this.f5165b).getClass();
                return true;
        }
    }

    @Override // x6.j
    public final z6.b0 b(Object obj, int i, int i10, x6.h hVar) {
        boolean z10;
        x xVar;
        s7.e eVar;
        switch (this.f5164a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                z6.b0 b0VarB = ((x6.j) this.f5165b).b(obj, i, i10, hVar);
                Resources resources = (Resources) this.f5166c;
                if (b0VarB == null) {
                    return null;
                }
                return new d(resources, b0VarB);
            case 1:
                z6.b0 b0VarC = ((i7.c) this.f5165b).c((Uri) obj, hVar);
                if (b0VarC == null) {
                    return null;
                }
                return r.b((a7.b) this.f5166c, (Drawable) ((i7.b) b0VarC).get(), i, i10);
            default:
                InputStream inputStream = (InputStream) obj;
                if (inputStream instanceof x) {
                    xVar = (x) inputStream;
                    z10 = false;
                } else {
                    z10 = true;
                    xVar = new x(inputStream, (a7.g) this.f5166c);
                }
                ArrayDeque arrayDeque = s7.e.f11593x;
                synchronized (arrayDeque) {
                    eVar = (s7.e) arrayDeque.poll();
                    break;
                }
                if (eVar == null) {
                    eVar = new s7.e();
                }
                s7.e eVar2 = eVar;
                eVar2.f11594v = xVar;
                s7.j jVar = new s7.j(eVar2);
                l4.c0 c0Var = new l4.c0(25, xVar, eVar2);
                try {
                    p pVar = (p) this.f5165b;
                    d dVarA = pVar.a(new androidx.emoji2.text.v(jVar, pVar.f5211d, pVar.f5210c), i, i10, hVar, c0Var);
                    eVar2.a();
                    if (z10) {
                        xVar.g();
                    }
                    return dVarA;
                } finally {
                }
        }
    }

    public a(Resources resources, x6.j jVar) {
        this.f5164a = 0;
        this.f5166c = resources;
        this.f5165b = jVar;
    }
}
