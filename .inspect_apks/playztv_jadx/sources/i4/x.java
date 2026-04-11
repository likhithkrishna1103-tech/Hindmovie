package i4;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.ui.PlayerView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x {
    public boolean A;
    public boolean B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f6325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f6326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f6327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f6328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup f6329e;
    public final ViewGroup f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewGroup f6330g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ViewGroup f6331h;
    public final ViewGroup i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f6332j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f6333k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AnimatorSet f6334l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AnimatorSet f6335m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AnimatorSet f6336n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AnimatorSet f6337o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AnimatorSet f6338p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ValueAnimator f6339q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ValueAnimator f6340r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final t f6341s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final t f6342t;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final t f6345w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final f f6346x;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final t f6343u = new t(this, 4);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final t f6344v = new t(this, 5);
    public boolean C = true;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f6348z = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ArrayList f6347y = new ArrayList();

    public x(s sVar) {
        this.f6325a = sVar;
        final int i = 0;
        this.f6341s = new t(this, i);
        final int i10 = 3;
        this.f6342t = new t(this, i10);
        int i11 = 6;
        this.f6345w = new t(this, i11);
        final int i12 = 1;
        this.f6346x = new f(i12, this);
        this.f6326b = sVar.findViewById(h0.exo_controls_background);
        this.f6327c = (ViewGroup) sVar.findViewById(h0.exo_center_controls);
        this.f6329e = (ViewGroup) sVar.findViewById(h0.exo_minimal_controls);
        ViewGroup viewGroup = (ViewGroup) sVar.findViewById(h0.exo_bottom_bar);
        this.f6328d = viewGroup;
        this.i = (ViewGroup) sVar.findViewById(h0.exo_time);
        View viewFindViewById = sVar.findViewById(h0.exo_progress);
        this.f6332j = viewFindViewById;
        this.f = (ViewGroup) sVar.findViewById(h0.exo_basic_controls);
        this.f6330g = (ViewGroup) sVar.findViewById(h0.exo_extra_controls);
        this.f6331h = (ViewGroup) sVar.findViewById(h0.exo_extra_controls_scroll_view);
        View viewFindViewById2 = sVar.findViewById(h0.exo_overflow_show);
        this.f6333k = viewFindViewById2;
        View viewFindViewById3 = sVar.findViewById(h0.exo_overflow_hide);
        if (viewFindViewById2 != null && viewFindViewById3 != null) {
            viewFindViewById2.setOnClickListener(new com.google.android.material.datepicker.n(i11, this));
            viewFindViewById3.setOnClickListener(new com.google.android.material.datepicker.n(i11, this));
        }
        final int i13 = 2;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: i4.u

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ x f6317b;

            {
                this.f6317b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        x xVar = this.f6317b;
                        xVar.getClass();
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view = xVar.f6326b;
                        if (view != null) {
                            view.setAlpha(fFloatValue);
                        }
                        ViewGroup viewGroup2 = xVar.f6327c;
                        if (viewGroup2 != null) {
                            viewGroup2.setAlpha(fFloatValue);
                        }
                        ViewGroup viewGroup3 = xVar.f6329e;
                        if (viewGroup3 != null) {
                            viewGroup3.setAlpha(fFloatValue);
                        }
                        break;
                    case 1:
                        x xVar2 = this.f6317b;
                        xVar2.getClass();
                        xVar2.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    case 2:
                        x xVar3 = this.f6317b;
                        xVar3.getClass();
                        xVar3.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        x xVar4 = this.f6317b;
                        xVar4.getClass();
                        float fFloatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view2 = xVar4.f6326b;
                        if (view2 != null) {
                            view2.setAlpha(fFloatValue2);
                        }
                        ViewGroup viewGroup4 = xVar4.f6327c;
                        if (viewGroup4 != null) {
                            viewGroup4.setAlpha(fFloatValue2);
                        }
                        ViewGroup viewGroup5 = xVar4.f6329e;
                        if (viewGroup5 != null) {
                            viewGroup5.setAlpha(fFloatValue2);
                        }
                        break;
                }
            }
        });
        valueAnimatorOfFloat.addListener(new v(this, i));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: i4.u

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ x f6317b;

            {
                this.f6317b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        x xVar = this.f6317b;
                        xVar.getClass();
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view = xVar.f6326b;
                        if (view != null) {
                            view.setAlpha(fFloatValue);
                        }
                        ViewGroup viewGroup2 = xVar.f6327c;
                        if (viewGroup2 != null) {
                            viewGroup2.setAlpha(fFloatValue);
                        }
                        ViewGroup viewGroup3 = xVar.f6329e;
                        if (viewGroup3 != null) {
                            viewGroup3.setAlpha(fFloatValue);
                        }
                        break;
                    case 1:
                        x xVar2 = this.f6317b;
                        xVar2.getClass();
                        xVar2.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    case 2:
                        x xVar3 = this.f6317b;
                        xVar3.getClass();
                        xVar3.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        x xVar4 = this.f6317b;
                        xVar4.getClass();
                        float fFloatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view2 = xVar4.f6326b;
                        if (view2 != null) {
                            view2.setAlpha(fFloatValue2);
                        }
                        ViewGroup viewGroup4 = xVar4.f6327c;
                        if (viewGroup4 != null) {
                            viewGroup4.setAlpha(fFloatValue2);
                        }
                        ViewGroup viewGroup5 = xVar4.f6329e;
                        if (viewGroup5 != null) {
                            viewGroup5.setAlpha(fFloatValue2);
                        }
                        break;
                }
            }
        });
        valueAnimatorOfFloat2.addListener(new v(this, i12));
        Resources resources = sVar.getResources();
        float dimension = resources.getDimension(e0.exo_styled_bottom_bar_height) - resources.getDimension(e0.exo_styled_progress_bar_height);
        float dimension2 = resources.getDimension(e0.exo_styled_bottom_bar_height);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f6334l = animatorSet;
        animatorSet.setDuration(250L);
        animatorSet.addListener(new w(this, sVar, i));
        animatorSet.play(valueAnimatorOfFloat).with(d(viewFindViewById, 0.0f, dimension)).with(d(viewGroup, 0.0f, dimension));
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f6335m = animatorSet2;
        animatorSet2.setDuration(250L);
        animatorSet2.addListener(new w(this, sVar, i12));
        animatorSet2.play(d(viewFindViewById, dimension, dimension2)).with(d(viewGroup, dimension, dimension2));
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.f6336n = animatorSet3;
        animatorSet3.setDuration(250L);
        animatorSet3.addListener(new w(this, sVar, i13));
        animatorSet3.play(valueAnimatorOfFloat).with(d(viewFindViewById, 0.0f, dimension2)).with(d(viewGroup, 0.0f, dimension2));
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.f6337o = animatorSet4;
        animatorSet4.setDuration(250L);
        animatorSet4.addListener(new v(this, i13));
        animatorSet4.play(valueAnimatorOfFloat2).with(d(viewFindViewById, dimension, 0.0f)).with(d(viewGroup, dimension, 0.0f));
        AnimatorSet animatorSet5 = new AnimatorSet();
        this.f6338p = animatorSet5;
        animatorSet5.setDuration(250L);
        animatorSet5.addListener(new v(this, i10));
        animatorSet5.play(valueAnimatorOfFloat2).with(d(viewFindViewById, dimension2, 0.0f)).with(d(viewGroup, dimension2, 0.0f));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f6339q = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.setDuration(250L);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: i4.u

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ x f6317b;

            {
                this.f6317b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i12) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        x xVar = this.f6317b;
                        xVar.getClass();
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view = xVar.f6326b;
                        if (view != null) {
                            view.setAlpha(fFloatValue);
                        }
                        ViewGroup viewGroup2 = xVar.f6327c;
                        if (viewGroup2 != null) {
                            viewGroup2.setAlpha(fFloatValue);
                        }
                        ViewGroup viewGroup3 = xVar.f6329e;
                        if (viewGroup3 != null) {
                            viewGroup3.setAlpha(fFloatValue);
                        }
                        break;
                    case 1:
                        x xVar2 = this.f6317b;
                        xVar2.getClass();
                        xVar2.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    case 2:
                        x xVar3 = this.f6317b;
                        xVar3.getClass();
                        xVar3.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        x xVar4 = this.f6317b;
                        xVar4.getClass();
                        float fFloatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view2 = xVar4.f6326b;
                        if (view2 != null) {
                            view2.setAlpha(fFloatValue2);
                        }
                        ViewGroup viewGroup4 = xVar4.f6327c;
                        if (viewGroup4 != null) {
                            viewGroup4.setAlpha(fFloatValue2);
                        }
                        ViewGroup viewGroup5 = xVar4.f6329e;
                        if (viewGroup5 != null) {
                            viewGroup5.setAlpha(fFloatValue2);
                        }
                        break;
                }
            }
        });
        valueAnimatorOfFloat3.addListener(new v(this, 4));
        ValueAnimator valueAnimatorOfFloat4 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f6340r = valueAnimatorOfFloat4;
        valueAnimatorOfFloat4.setDuration(250L);
        valueAnimatorOfFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: i4.u

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ x f6317b;

            {
                this.f6317b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i13) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        x xVar = this.f6317b;
                        xVar.getClass();
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view = xVar.f6326b;
                        if (view != null) {
                            view.setAlpha(fFloatValue);
                        }
                        ViewGroup viewGroup2 = xVar.f6327c;
                        if (viewGroup2 != null) {
                            viewGroup2.setAlpha(fFloatValue);
                        }
                        ViewGroup viewGroup3 = xVar.f6329e;
                        if (viewGroup3 != null) {
                            viewGroup3.setAlpha(fFloatValue);
                        }
                        break;
                    case 1:
                        x xVar2 = this.f6317b;
                        xVar2.getClass();
                        xVar2.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    case 2:
                        x xVar3 = this.f6317b;
                        xVar3.getClass();
                        xVar3.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        x xVar4 = this.f6317b;
                        xVar4.getClass();
                        float fFloatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view2 = xVar4.f6326b;
                        if (view2 != null) {
                            view2.setAlpha(fFloatValue2);
                        }
                        ViewGroup viewGroup4 = xVar4.f6327c;
                        if (viewGroup4 != null) {
                            viewGroup4.setAlpha(fFloatValue2);
                        }
                        ViewGroup viewGroup5 = xVar4.f6329e;
                        if (viewGroup5 != null) {
                            viewGroup5.setAlpha(fFloatValue2);
                        }
                        break;
                }
            }
        });
        valueAnimatorOfFloat4.addListener(new v(this, 5));
    }

    public static int c(View view) {
        if (view == null) {
            return 0;
        }
        int width = view.getWidth();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return width;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + width;
    }

    public static ObjectAnimator d(View view, float f, float f4) {
        return ObjectAnimator.ofFloat(view, "translationY", f, f4);
    }

    public static boolean j(View view) {
        int id2 = view.getId();
        return id2 == h0.exo_bottom_bar || id2 == h0.exo_prev || id2 == h0.exo_next || id2 == h0.exo_rew || id2 == h0.exo_rew_with_amount || id2 == h0.exo_ffwd || id2 == h0.exo_ffwd_with_amount;
    }

    public final void a(float f) {
        ViewGroup viewGroup = this.f6331h;
        if (viewGroup != null) {
            viewGroup.setTranslationX((int) ((1.0f - f) * viewGroup.getWidth()));
        }
        ViewGroup viewGroup2 = this.i;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(1.0f - f);
        }
        ViewGroup viewGroup3 = this.f;
        if (viewGroup3 != null) {
            viewGroup3.setAlpha(1.0f - f);
        }
    }

    public final boolean b(View view) {
        return view != null && this.f6347y.contains(view);
    }

    public final void e(Runnable runnable, long j5) {
        if (j5 >= 0) {
            this.f6325a.postDelayed(runnable, j5);
        }
    }

    public final void f() {
        t tVar = this.f6345w;
        s sVar = this.f6325a;
        sVar.removeCallbacks(tVar);
        sVar.removeCallbacks(this.f6342t);
        sVar.removeCallbacks(this.f6344v);
        sVar.removeCallbacks(this.f6343u);
    }

    public final void g() {
        if (this.f6348z == 3) {
            return;
        }
        f();
        int showTimeoutMs = this.f6325a.getShowTimeoutMs();
        if (showTimeoutMs > 0) {
            if (!this.C) {
                e(this.f6345w, showTimeoutMs);
            } else if (this.f6348z == 1) {
                e(this.f6343u, 2000L);
            } else {
                e(this.f6344v, showTimeoutMs);
            }
        }
    }

    public final void h(View view, boolean z2) {
        if (view == null) {
            return;
        }
        ArrayList arrayList = this.f6347y;
        if (!z2) {
            view.setVisibility(8);
            arrayList.remove(view);
            return;
        }
        if (this.A && j(view)) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
        }
        arrayList.add(view);
    }

    public final void i(int i) {
        int i10 = this.f6348z;
        this.f6348z = i;
        s sVar = this.f6325a;
        if (i == 2) {
            sVar.setVisibility(8);
        } else if (i10 == 2) {
            sVar.setVisibility(0);
        }
        if (i10 != i) {
            for (r rVar : sVar.f6284x) {
                int visibility = sVar.getVisibility();
                PlayerView playerView = ((z) rVar).f6352w;
                playerView.l();
                a0 a0Var = playerView.I;
                if (a0Var != null) {
                    gc.g gVar = (gc.g) ((wb.c) a0Var).f14088v;
                    if (!gVar.K && !gVar.L) {
                        gVar.I = visibility == 0;
                    }
                }
            }
        }
    }

    public final void k() {
        if (!this.C) {
            i(0);
            g();
            return;
        }
        int i = this.f6348z;
        if (i == 1) {
            this.f6337o.start();
        } else if (i == 2) {
            this.f6338p.start();
        } else if (i == 3) {
            this.B = true;
        } else if (i == 4) {
            return;
        }
        g();
    }
}
