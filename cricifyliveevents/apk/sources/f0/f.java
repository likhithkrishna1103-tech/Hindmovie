package f0;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.media3.decoder.DecoderInputBuffer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f3911v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f3912w;

    public f(p7.e eVar) {
        this.f3912w = new WeakReference(eVar);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() throws Throwable {
        switch (this.f3911v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((CoordinatorLayout) this.f3912w).q(0);
                break;
            default:
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                p7.e eVar = (p7.e) ((WeakReference) this.f3912w).get();
                if (eVar != null) {
                    ArrayList arrayList = eVar.f10045b;
                    View view = eVar.f10044a;
                    if (!arrayList.isEmpty()) {
                        int paddingRight = view.getPaddingRight() + view.getPaddingLeft();
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        int i = 0;
                        int iA = eVar.a(view.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
                        int paddingBottom = view.getPaddingBottom() + view.getPaddingTop();
                        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                        int iA2 = eVar.a(view.getHeight(), layoutParams2 != null ? layoutParams2.height : 0, paddingBottom);
                        if (iA > 0 || iA == Integer.MIN_VALUE) {
                            if (iA2 > 0 || iA2 == Integer.MIN_VALUE) {
                                ArrayList arrayList2 = new ArrayList(arrayList);
                                int size = arrayList2.size();
                                while (i < size) {
                                    Object obj = arrayList2.get(i);
                                    i++;
                                    ((o7.h) ((p7.c) obj)).m(iA, iA2);
                                }
                                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                                if (viewTreeObserver.isAlive()) {
                                    viewTreeObserver.removeOnPreDrawListener(eVar.f10046c);
                                }
                                eVar.f10046c = null;
                                arrayList.clear();
                            }
                        }
                        break;
                    }
                }
                break;
        }
        return true;
    }

    public f(CoordinatorLayout coordinatorLayout) {
        this.f3912w = coordinatorLayout;
    }
}
