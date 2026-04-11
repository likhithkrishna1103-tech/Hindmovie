package v4;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f13184v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ ArrayList f13185w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ h f13186x;

    public /* synthetic */ b(h hVar, ArrayList arrayList, int i) {
        this.f13184v = i;
        this.f13186x = hVar;
        this.f13185w = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13184v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ArrayList arrayList = this.f13185w;
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    h hVar = this.f13186x;
                    if (i >= size) {
                        arrayList.clear();
                        hVar.f13241m.remove(arrayList);
                    } else {
                        Object obj = arrayList.get(i);
                        i++;
                        g gVar = (g) obj;
                        x0 x0Var = gVar.f13226a;
                        int i10 = gVar.f13227b;
                        int i11 = gVar.f13228c;
                        int i12 = gVar.f13229d;
                        int i13 = gVar.f13230e;
                        hVar.getClass();
                        View view = x0Var.f13387a;
                        int i14 = i12 - i10;
                        int i15 = i13 - i11;
                        if (i14 != 0) {
                            view.animate().translationX(0.0f);
                        }
                        if (i15 != 0) {
                            view.animate().translationY(0.0f);
                        }
                        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
                        hVar.f13244p.add(x0Var);
                        viewPropertyAnimatorAnimate.setDuration(hVar.f13216e).setListener(new d(hVar, x0Var, i14, view, i15, viewPropertyAnimatorAnimate)).start();
                    }
                    break;
                }
                break;
            case 1:
                ArrayList arrayList2 = this.f13185w;
                int size2 = arrayList2.size();
                int i16 = 0;
                while (true) {
                    h hVar2 = this.f13186x;
                    if (i16 >= size2) {
                        arrayList2.clear();
                        hVar2.f13242n.remove(arrayList2);
                        break;
                    } else {
                        Object obj2 = arrayList2.get(i16);
                        i16++;
                        f fVar = (f) obj2;
                        ArrayList arrayList3 = hVar2.f13246r;
                        long j4 = hVar2.f;
                        x0 x0Var2 = fVar.f13217a;
                        View view2 = x0Var2 == null ? null : x0Var2.f13387a;
                        x0 x0Var3 = fVar.f13218b;
                        View view3 = x0Var3 != null ? x0Var3.f13387a : null;
                        if (view2 != null) {
                            ViewPropertyAnimator duration = view2.animate().setDuration(j4);
                            arrayList3.add(fVar.f13217a);
                            duration.translationX(fVar.f13221e - fVar.f13219c);
                            duration.translationY(fVar.f - fVar.f13220d);
                            duration.alpha(0.0f).setListener(new e(hVar2, fVar, duration, view2, 0)).start();
                        }
                        if (view3 != null) {
                            ViewPropertyAnimator viewPropertyAnimatorAnimate2 = view3.animate();
                            arrayList3.add(fVar.f13218b);
                            viewPropertyAnimatorAnimate2.translationX(0.0f).translationY(0.0f).setDuration(j4).alpha(1.0f).setListener(new e(hVar2, fVar, viewPropertyAnimatorAnimate2, view3, 1)).start();
                        }
                    }
                }
                break;
            default:
                ArrayList arrayList4 = this.f13185w;
                int size3 = arrayList4.size();
                int i17 = 0;
                while (true) {
                    h hVar3 = this.f13186x;
                    if (i17 >= size3) {
                        arrayList4.clear();
                        hVar3.f13240l.remove(arrayList4);
                    } else {
                        Object obj3 = arrayList4.get(i17);
                        i17++;
                        x0 x0Var4 = (x0) obj3;
                        hVar3.getClass();
                        View view4 = x0Var4.f13387a;
                        ViewPropertyAnimator viewPropertyAnimatorAnimate3 = view4.animate();
                        hVar3.f13243o.add(x0Var4);
                        viewPropertyAnimatorAnimate3.alpha(1.0f).setDuration(hVar3.f13214c).setListener(new c(hVar3, x0Var4, view4, viewPropertyAnimatorAnimate3)).start();
                    }
                    break;
                }
                break;
        }
    }
}
