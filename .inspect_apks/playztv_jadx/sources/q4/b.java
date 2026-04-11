package q4;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f10747u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ ArrayList f10748v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ h f10749w;

    public /* synthetic */ b(h hVar, ArrayList arrayList, int i) {
        this.f10747u = i;
        this.f10749w = hVar;
        this.f10748v = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10747u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ArrayList arrayList = this.f10748v;
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    h hVar = this.f10749w;
                    if (i >= size) {
                        arrayList.clear();
                        hVar.f10811m.remove(arrayList);
                    } else {
                        Object obj = arrayList.get(i);
                        i++;
                        g gVar = (g) obj;
                        x0 x0Var = gVar.f10792a;
                        int i10 = gVar.f10793b;
                        int i11 = gVar.f10794c;
                        int i12 = gVar.f10795d;
                        int i13 = gVar.f10796e;
                        hVar.getClass();
                        View view = x0Var.f10962a;
                        int i14 = i12 - i10;
                        int i15 = i13 - i11;
                        if (i14 != 0) {
                            view.animate().translationX(0.0f);
                        }
                        if (i15 != 0) {
                            view.animate().translationY(0.0f);
                        }
                        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
                        hVar.f10814p.add(x0Var);
                        viewPropertyAnimatorAnimate.setDuration(hVar.f10780e).setListener(new d(hVar, x0Var, i14, view, i15, viewPropertyAnimatorAnimate)).start();
                    }
                    break;
                }
                break;
            case 1:
                ArrayList arrayList2 = this.f10748v;
                int size2 = arrayList2.size();
                int i16 = 0;
                while (true) {
                    h hVar2 = this.f10749w;
                    if (i16 >= size2) {
                        arrayList2.clear();
                        hVar2.f10812n.remove(arrayList2);
                        break;
                    } else {
                        Object obj2 = arrayList2.get(i16);
                        i16++;
                        f fVar = (f) obj2;
                        ArrayList arrayList3 = hVar2.f10816r;
                        long j5 = hVar2.f;
                        x0 x0Var2 = fVar.f10787a;
                        View view2 = x0Var2 == null ? null : x0Var2.f10962a;
                        x0 x0Var3 = fVar.f10788b;
                        View view3 = x0Var3 != null ? x0Var3.f10962a : null;
                        if (view2 != null) {
                            ViewPropertyAnimator duration = view2.animate().setDuration(j5);
                            arrayList3.add(fVar.f10787a);
                            duration.translationX(fVar.f10791e - fVar.f10789c);
                            duration.translationY(fVar.f - fVar.f10790d);
                            duration.alpha(0.0f).setListener(new e(hVar2, fVar, duration, view2, 0)).start();
                        }
                        if (view3 != null) {
                            ViewPropertyAnimator viewPropertyAnimatorAnimate2 = view3.animate();
                            arrayList3.add(fVar.f10788b);
                            viewPropertyAnimatorAnimate2.translationX(0.0f).translationY(0.0f).setDuration(j5).alpha(1.0f).setListener(new e(hVar2, fVar, viewPropertyAnimatorAnimate2, view3, 1)).start();
                        }
                    }
                }
                break;
            default:
                ArrayList arrayList4 = this.f10748v;
                int size3 = arrayList4.size();
                int i17 = 0;
                while (true) {
                    h hVar3 = this.f10749w;
                    if (i17 >= size3) {
                        arrayList4.clear();
                        hVar3.f10810l.remove(arrayList4);
                    } else {
                        Object obj3 = arrayList4.get(i17);
                        i17++;
                        x0 x0Var4 = (x0) obj3;
                        hVar3.getClass();
                        View view4 = x0Var4.f10962a;
                        ViewPropertyAnimator viewPropertyAnimatorAnimate3 = view4.animate();
                        hVar3.f10813o.add(x0Var4);
                        viewPropertyAnimatorAnimate3.alpha(1.0f).setDuration(hVar3.f10778c).setListener(new c(hVar3, x0Var4, view4, viewPropertyAnimatorAnimate3)).start();
                    }
                    break;
                }
                break;
        }
    }
}
