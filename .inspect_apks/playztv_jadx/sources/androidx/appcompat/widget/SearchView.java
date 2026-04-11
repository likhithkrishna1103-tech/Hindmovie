package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.playz.tv.activities.MainActivity;
import df.i;
import g.f;
import g.g;
import g.h;
import g.j;
import hc.v;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import n.a3;
import n.l0;
import n.o;
import n.r2;
import n.s2;
import n.t2;
import n.u2;
import n.v2;
import n.w2;
import n.x2;
import n.y1;
import n.y2;
import n.z1;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class SearchView extends y1 implements l.b {
    public static final i C0;
    public final r2 A0;
    public final WeakHashMap B0;
    public final SearchAutoComplete J;
    public final View K;
    public final View L;
    public final View M;
    public final ImageView N;
    public final ImageView O;
    public final ImageView P;
    public final ImageView Q;
    public final View R;
    public y2 S;
    public final Rect T;
    public final Rect U;
    public final int[] V;
    public final int[] W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final ImageView f899a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final Drawable f900b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final int f901c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final int f902d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final Intent f903e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final Intent f904f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final CharSequence f905g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public v2 f906h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public View.OnFocusChangeListener f907i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public View.OnClickListener f908j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f909k0;
    public boolean l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public v0.a f910m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public boolean f911n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public CharSequence f912o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f913p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public boolean f914q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public int f915r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public boolean f916s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public String f917t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public CharSequence f918u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public boolean f919v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f920w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public SearchableInfo f921x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public Bundle f922y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public final r2 f923z0;

    static {
        i iVar = null;
        if (Build.VERSION.SDK_INT < 29) {
            i iVar2 = new i();
            iVar2.f4207a = null;
            iVar2.f4208b = null;
            iVar2.f4209c = null;
            i.a();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", null);
                iVar2.f4207a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", null);
                iVar2.f4208b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                iVar2.f4209c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
            iVar = iVar2;
        }
        C0 = iVar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SearchView(Context context) {
        int i = g.a.searchViewStyle;
        super(context, null, i);
        this.T = new Rect();
        this.U = new Rect();
        this.V = new int[2];
        this.W = new int[2];
        this.f923z0 = new r2(this, 0);
        this.A0 = new r2(this, 1);
        this.B0 = new WeakHashMap();
        a aVar = new a(this);
        b bVar = new b(this);
        t2 t2Var = new t2(this);
        int i10 = 1;
        l0 l0Var = new l0(i10, this);
        z1 z1Var = new z1(i10, this);
        v vVar = new v(2, this);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, j.SearchView, i, 0);
        kc.b bVar2 = new kc.b(context, typedArrayObtainStyledAttributes);
        o0.m(this, context, j.SearchView, null, typedArrayObtainStyledAttributes, i);
        LayoutInflater.from(context).inflate(typedArrayObtainStyledAttributes.getResourceId(j.SearchView_layout, g.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(f.search_src_text);
        this.J = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.K = findViewById(f.search_edit_frame);
        View viewFindViewById = findViewById(f.search_plate);
        this.L = viewFindViewById;
        View viewFindViewById2 = findViewById(f.submit_area);
        this.M = viewFindViewById2;
        ImageView imageView = (ImageView) findViewById(f.search_button);
        this.N = imageView;
        ImageView imageView2 = (ImageView) findViewById(f.search_go_btn);
        this.O = imageView2;
        ImageView imageView3 = (ImageView) findViewById(f.search_close_btn);
        this.P = imageView3;
        ImageView imageView4 = (ImageView) findViewById(f.search_voice_btn);
        this.Q = imageView4;
        ImageView imageView5 = (ImageView) findViewById(f.search_mag_icon);
        this.f899a0 = imageView5;
        viewFindViewById.setBackground(bVar2.s(j.SearchView_queryBackground));
        viewFindViewById2.setBackground(bVar2.s(j.SearchView_submitBackground));
        imageView.setImageDrawable(bVar2.s(j.SearchView_searchIcon));
        imageView2.setImageDrawable(bVar2.s(j.SearchView_goIcon));
        imageView3.setImageDrawable(bVar2.s(j.SearchView_closeIcon));
        imageView4.setImageDrawable(bVar2.s(j.SearchView_voiceIcon));
        imageView5.setImageDrawable(bVar2.s(j.SearchView_searchIcon));
        this.f900b0 = bVar2.s(j.SearchView_searchHintIcon);
        q1.c.N(imageView, getResources().getString(h.abc_searchview_description_search));
        this.f901c0 = typedArrayObtainStyledAttributes.getResourceId(j.SearchView_suggestionRowLayout, g.abc_search_dropdown_item_icons_2line);
        this.f902d0 = typedArrayObtainStyledAttributes.getResourceId(j.SearchView_commitIcon, 0);
        imageView.setOnClickListener(aVar);
        imageView3.setOnClickListener(aVar);
        imageView2.setOnClickListener(aVar);
        imageView4.setOnClickListener(aVar);
        searchAutoComplete.setOnClickListener(aVar);
        searchAutoComplete.addTextChangedListener(vVar);
        searchAutoComplete.setOnEditorActionListener(t2Var);
        searchAutoComplete.setOnItemClickListener(l0Var);
        searchAutoComplete.setOnItemSelectedListener(z1Var);
        searchAutoComplete.setOnKeyListener(bVar);
        searchAutoComplete.setOnFocusChangeListener(new s2(this));
        setIconifiedByDefault(typedArrayObtainStyledAttributes.getBoolean(j.SearchView_iconifiedByDefault, true));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(j.SearchView_android_maxWidth, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.f905g0 = typedArrayObtainStyledAttributes.getText(j.SearchView_defaultQueryHint);
        this.f912o0 = typedArrayObtainStyledAttributes.getText(j.SearchView_queryHint);
        int i11 = typedArrayObtainStyledAttributes.getInt(j.SearchView_android_imeOptions, -1);
        if (i11 != -1) {
            setImeOptions(i11);
        }
        int i12 = typedArrayObtainStyledAttributes.getInt(j.SearchView_android_inputType, -1);
        if (i12 != -1) {
            setInputType(i12);
        }
        setFocusable(typedArrayObtainStyledAttributes.getBoolean(j.SearchView_android_focusable, true));
        bVar2.E();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.f903e0 = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f904f0 = intent2;
        intent2.addFlags(268435456);
        View viewFindViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.R = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.addOnLayoutChangeListener(new l9.b(1, this));
        }
        w(this.f909k0);
        t();
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(g.d.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(g.d.abc_search_view_preferred_width);
    }

    private void setQuery(CharSequence charSequence) {
        SearchAutoComplete searchAutoComplete = this.J;
        searchAutoComplete.setText(charSequence);
        searchAutoComplete.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void clearFocus() {
        this.f914q0 = true;
        super.clearFocus();
        SearchAutoComplete searchAutoComplete = this.J;
        searchAutoComplete.clearFocus();
        searchAutoComplete.setImeVisibility(false);
        this.f914q0 = false;
    }

    public int getImeOptions() {
        return this.J.getImeOptions();
    }

    public int getInputType() {
        return this.J.getInputType();
    }

    public int getMaxWidth() {
        return this.f915r0;
    }

    public CharSequence getQuery() {
        return this.J.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f912o0;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f921x0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.f905g0 : getContext().getText(this.f921x0.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.f902d0;
    }

    public int getSuggestionRowLayout() {
        return this.f901c0;
    }

    public v0.a getSuggestionsAdapter() {
        return this.f910m0;
    }

    public final Intent j(String str, Uri uri, String str2, String str3) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f918u0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f922y0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        intent.setComponent(this.f921x0.getSearchActivity());
        return intent;
    }

    public final Intent k(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f922y0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    public final void l() {
        int i = Build.VERSION.SDK_INT;
        SearchAutoComplete searchAutoComplete = this.J;
        if (i >= 29) {
            c.a(searchAutoComplete);
            return;
        }
        i iVar = C0;
        iVar.getClass();
        i.a();
        Method method = iVar.f4207a;
        if (method != null) {
            try {
                method.invoke(searchAutoComplete, null);
            } catch (Exception unused) {
            }
        }
        iVar.getClass();
        i.a();
        Method method2 = iVar.f4208b;
        if (method2 != null) {
            try {
                method2.invoke(searchAutoComplete, null);
            } catch (Exception unused2) {
            }
        }
    }

    public final void m() {
        SearchAutoComplete searchAutoComplete = this.J;
        if (!TextUtils.isEmpty(searchAutoComplete.getText())) {
            searchAutoComplete.setText("");
            searchAutoComplete.requestFocus();
            searchAutoComplete.setImeVisibility(true);
        } else if (this.f909k0) {
            clearFocus();
            w(true);
        }
    }

    public final void n(int i) {
        int position;
        String strH;
        Cursor cursor = this.f910m0.f13113w;
        if (cursor != null && cursor.moveToPosition(i)) {
            Intent intentJ = null;
            try {
                int i10 = a3.R;
                String strH2 = a3.h(cursor, cursor.getColumnIndex("suggest_intent_action"));
                if (strH2 == null) {
                    strH2 = this.f921x0.getSuggestIntentAction();
                }
                if (strH2 == null) {
                    strH2 = "android.intent.action.SEARCH";
                }
                String strH3 = a3.h(cursor, cursor.getColumnIndex("suggest_intent_data"));
                if (strH3 == null) {
                    strH3 = this.f921x0.getSuggestIntentData();
                }
                if (strH3 != null && (strH = a3.h(cursor, cursor.getColumnIndex("suggest_intent_data_id"))) != null) {
                    strH3 = strH3 + "/" + Uri.encode(strH);
                }
                intentJ = j(strH2, strH3 == null ? null : Uri.parse(strH3), a3.h(cursor, cursor.getColumnIndex("suggest_intent_extra_data")), a3.h(cursor, cursor.getColumnIndex("suggest_intent_query")));
            } catch (RuntimeException e10) {
                try {
                    position = cursor.getPosition();
                } catch (RuntimeException unused) {
                    position = -1;
                }
                Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", e10);
            }
            if (intentJ != null) {
                try {
                    getContext().startActivity(intentJ);
                } catch (RuntimeException e11) {
                    Log.e("SearchView", "Failed launch activity: " + intentJ, e11);
                }
            }
        }
        SearchAutoComplete searchAutoComplete = this.J;
        searchAutoComplete.setImeVisibility(false);
        searchAutoComplete.dismissDropDown();
    }

    public final void o(int i) {
        Editable text = this.J.getText();
        Cursor cursor = this.f910m0.f13113w;
        if (cursor == null) {
            return;
        }
        if (!cursor.moveToPosition(i)) {
            setQuery(text);
            return;
        }
        String strC = this.f910m0.c(cursor);
        if (strC != null) {
            setQuery(strC);
        } else {
            setQuery(text);
        }
    }

    @Override // l.b
    public final void onActionViewCollapsed() {
        SearchAutoComplete searchAutoComplete = this.J;
        searchAutoComplete.setText("");
        searchAutoComplete.setSelection(searchAutoComplete.length());
        this.f918u0 = "";
        clearFocus();
        w(true);
        searchAutoComplete.setImeOptions(this.f920w0);
        this.f919v0 = false;
    }

    @Override // l.b
    public final void onActionViewExpanded() {
        if (this.f919v0) {
            return;
        }
        this.f919v0 = true;
        SearchAutoComplete searchAutoComplete = this.J;
        int imeOptions = searchAutoComplete.getImeOptions();
        this.f920w0 = imeOptions;
        searchAutoComplete.setImeOptions(imeOptions | 33554432);
        searchAutoComplete.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.f923z0);
        post(this.A0);
        super.onDetachedFromWindow();
    }

    @Override // n.y1, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i, int i10, int i11, int i12) {
        super.onLayout(z2, i, i10, i11, i12);
        if (z2) {
            SearchAutoComplete searchAutoComplete = this.J;
            int[] iArr = this.V;
            searchAutoComplete.getLocationInWindow(iArr);
            int[] iArr2 = this.W;
            getLocationInWindow(iArr2);
            int i13 = iArr[1] - iArr2[1];
            int i14 = iArr[0] - iArr2[0];
            int width = searchAutoComplete.getWidth() + i14;
            int height = searchAutoComplete.getHeight() + i13;
            Rect rect = this.T;
            rect.set(i14, i13, width, height);
            int i15 = rect.left;
            int i16 = rect.right;
            int i17 = i12 - i10;
            Rect rect2 = this.U;
            rect2.set(i15, 0, i16, i17);
            y2 y2Var = this.S;
            if (y2Var == null) {
                y2 y2Var2 = new y2(searchAutoComplete, rect2, rect);
                this.S = y2Var2;
                setTouchDelegate(y2Var2);
            } else {
                y2Var.f8591b.set(rect2);
                Rect rect3 = y2Var.f8593d;
                rect3.set(rect2);
                int i18 = -y2Var.f8594e;
                rect3.inset(i18, i18);
                y2Var.f8592c.set(rect);
            }
        }
    }

    @Override // n.y1, android.view.View
    public final void onMeasure(int i, int i10) {
        int i11;
        if (this.l0) {
            super.onMeasure(i, i10);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            int i12 = this.f915r0;
            size = i12 > 0 ? Math.min(i12, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.f915r0;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i11 = this.f915r0) > 0) {
            size = Math.min(i11, size);
        }
        int mode2 = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i10);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof x2)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        x2 x2Var = (x2) parcelable;
        super.onRestoreInstanceState(x2Var.f14205u);
        w(x2Var.f8569w);
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        x2 x2Var = new x2(super.onSaveInstanceState());
        x2Var.f8569w = this.l0;
        return x2Var;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        post(this.f923z0);
    }

    public final void p(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public final void q() {
        SearchAutoComplete searchAutoComplete = this.J;
        Editable text = searchAutoComplete.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        v2 v2Var = this.f906h0;
        if (v2Var != null) {
            MainActivity.w((MainActivity) ((u5.c) v2Var).f12782v, text.toString());
            return;
        }
        if (this.f921x0 != null) {
            getContext().startActivity(j("android.intent.action.SEARCH", null, null, text.toString()));
        }
        searchAutoComplete.setImeVisibility(false);
        searchAutoComplete.dismissDropDown();
    }

    public final void r() {
        boolean zIsEmpty = TextUtils.isEmpty(this.J.getText());
        int i = (!zIsEmpty || (this.f909k0 && !this.f919v0)) ? 0 : 8;
        ImageView imageView = this.P;
        imageView.setVisibility(i);
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            drawable.setState(!zIsEmpty ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean requestFocus(int i, Rect rect) {
        if (this.f914q0 || !isFocusable()) {
            return false;
        }
        if (this.l0) {
            return super.requestFocus(i, rect);
        }
        boolean zRequestFocus = this.J.requestFocus(i, rect);
        if (zRequestFocus) {
            w(false);
        }
        return zRequestFocus;
    }

    public final void s() {
        int[] iArr = this.J.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.L.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.M.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public void setAppSearchData(Bundle bundle) {
        this.f922y0 = bundle;
    }

    public void setIconified(boolean z2) {
        if (z2) {
            m();
            return;
        }
        w(false);
        SearchAutoComplete searchAutoComplete = this.J;
        searchAutoComplete.requestFocus();
        searchAutoComplete.setImeVisibility(true);
        View.OnClickListener onClickListener = this.f908j0;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void setIconifiedByDefault(boolean z2) {
        if (this.f909k0 == z2) {
            return;
        }
        this.f909k0 = z2;
        w(z2);
        t();
    }

    public void setImeOptions(int i) {
        this.J.setImeOptions(i);
    }

    public void setInputType(int i) {
        this.J.setInputType(i);
    }

    public void setMaxWidth(int i) {
        this.f915r0 = i;
        requestLayout();
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f907i0 = onFocusChangeListener;
    }

    public void setOnQueryTextListener(v2 v2Var) {
        this.f906h0 = v2Var;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f908j0 = onClickListener;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f912o0 = charSequence;
        t();
    }

    public void setQueryRefinementEnabled(boolean z2) {
        this.f913p0 = z2;
        v0.a aVar = this.f910m0;
        if (aVar instanceof a3) {
            ((a3) aVar).J = z2 ? 2 : 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setSearchableInfo(android.app.SearchableInfo r7) {
        /*
            r6 = this;
            r6.f921x0 = r7
            r0 = 0
            r1 = 1
            androidx.appcompat.widget.SearchView$SearchAutoComplete r2 = r6.J
            if (r7 == 0) goto L65
            int r7 = r7.getSuggestThreshold()
            r2.setThreshold(r7)
            android.app.SearchableInfo r7 = r6.f921x0
            int r7 = r7.getImeOptions()
            r2.setImeOptions(r7)
            android.app.SearchableInfo r7 = r6.f921x0
            int r7 = r7.getInputType()
            r3 = r7 & 15
            if (r3 != r1) goto L31
            r3 = -65537(0xfffffffffffeffff, float:NaN)
            r7 = r7 & r3
            android.app.SearchableInfo r3 = r6.f921x0
            java.lang.String r3 = r3.getSuggestAuthority()
            if (r3 == 0) goto L31
            r3 = 589824(0x90000, float:8.2652E-40)
            r7 = r7 | r3
        L31:
            r2.setInputType(r7)
            v0.a r7 = r6.f910m0
            if (r7 == 0) goto L3b
            r7.b(r0)
        L3b:
            android.app.SearchableInfo r7 = r6.f921x0
            java.lang.String r7 = r7.getSuggestAuthority()
            if (r7 == 0) goto L62
            n.a3 r7 = new n.a3
            android.content.Context r3 = r6.getContext()
            android.app.SearchableInfo r4 = r6.f921x0
            java.util.WeakHashMap r5 = r6.B0
            r7.<init>(r3, r6, r4, r5)
            r6.f910m0 = r7
            r2.setAdapter(r7)
            v0.a r7 = r6.f910m0
            n.a3 r7 = (n.a3) r7
            boolean r3 = r6.f913p0
            if (r3 == 0) goto L5f
            r3 = 2
            goto L60
        L5f:
            r3 = r1
        L60:
            r7.J = r3
        L62:
            r6.t()
        L65:
            android.app.SearchableInfo r7 = r6.f921x0
            r3 = 0
            if (r7 == 0) goto L98
            boolean r7 = r7.getVoiceSearchEnabled()
            if (r7 == 0) goto L98
            android.app.SearchableInfo r7 = r6.f921x0
            boolean r7 = r7.getVoiceSearchLaunchWebSearch()
            if (r7 == 0) goto L7b
            android.content.Intent r0 = r6.f903e0
            goto L85
        L7b:
            android.app.SearchableInfo r7 = r6.f921x0
            boolean r7 = r7.getVoiceSearchLaunchRecognizer()
            if (r7 == 0) goto L85
            android.content.Intent r0 = r6.f904f0
        L85:
            if (r0 == 0) goto L98
            android.content.Context r7 = r6.getContext()
            android.content.pm.PackageManager r7 = r7.getPackageManager()
            r4 = 65536(0x10000, float:9.1835E-41)
            android.content.pm.ResolveInfo r7 = r7.resolveActivity(r0, r4)
            if (r7 == 0) goto L98
            goto L99
        L98:
            r1 = r3
        L99:
            r6.f916s0 = r1
            if (r1 == 0) goto La2
            java.lang.String r7 = "nm"
            r2.setPrivateImeOptions(r7)
        La2:
            boolean r7 = r6.l0
            r6.w(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.setSearchableInfo(android.app.SearchableInfo):void");
    }

    public void setSubmitButtonEnabled(boolean z2) {
        this.f911n0 = z2;
        w(this.l0);
    }

    public void setSuggestionsAdapter(v0.a aVar) {
        this.f910m0 = aVar;
        this.J.setAdapter(aVar);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void t() {
        CharSequence queryHint = getQueryHint();
        CharSequence charSequence = queryHint;
        if (queryHint == null) {
            charSequence = "";
        }
        boolean z2 = this.f909k0;
        SearchAutoComplete searchAutoComplete = this.J;
        CharSequence charSequence2 = charSequence;
        if (z2) {
            Drawable drawable = this.f900b0;
            charSequence2 = charSequence;
            if (drawable != null) {
                int textSize = (int) (((double) searchAutoComplete.getTextSize()) * 1.25d);
                drawable.setBounds(0, 0, textSize, textSize);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
                spannableStringBuilder.setSpan(new ImageSpan(drawable), 1, 2, 33);
                spannableStringBuilder.append(charSequence);
                charSequence2 = spannableStringBuilder;
            }
        }
        searchAutoComplete.setHint(charSequence2);
    }

    public final void u() {
        this.M.setVisibility(((this.f911n0 || this.f916s0) && !this.l0 && (this.O.getVisibility() == 0 || this.Q.getVisibility() == 0)) ? 0 : 8);
    }

    public final void v(boolean z2) {
        boolean z10 = this.f911n0;
        this.O.setVisibility((!z10 || !(z10 || this.f916s0) || this.l0 || !hasFocus() || (!z2 && this.f916s0)) ? 8 : 0);
    }

    public final void w(boolean z2) {
        this.l0 = z2;
        int i = 8;
        int i10 = z2 ? 0 : 8;
        boolean zIsEmpty = TextUtils.isEmpty(this.J.getText());
        this.N.setVisibility(i10);
        v(!zIsEmpty);
        this.K.setVisibility(z2 ? 8 : 0);
        ImageView imageView = this.f899a0;
        imageView.setVisibility((imageView.getDrawable() == null || this.f909k0) ? 8 : 0);
        r();
        if (this.f916s0 && !this.l0 && zIsEmpty) {
            this.O.setVisibility(8);
            i = 0;
        }
        this.Q.setVisibility(i);
        u();
    }

    /* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
    public static class SearchAutoComplete extends o {
        public boolean A;
        public final d B;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f924y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public SearchView f925z;

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            super(context, attributeSet, g.a.autoCompleteTextViewStyle);
            this.B = new d(this);
            this.f924y = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i10 = configuration.screenHeightDp;
            if (i >= 960 && i10 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i < 600) {
                return (i < 640 || i10 < 480) ? 160 : 192;
            }
            return 192;
        }

        public final void a() {
            if (Build.VERSION.SDK_INT >= 29) {
                c.b(this, 1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            i iVar = SearchView.C0;
            iVar.getClass();
            i.a();
            Method method = iVar.f4209c;
            if (method != null) {
                try {
                    method.invoke(this, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public final boolean enoughToFilter() {
            return this.f924y <= 0 || super.enoughToFilter();
        }

        @Override // n.o, android.widget.TextView, android.view.View
        public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.A) {
                d dVar = this.B;
                removeCallbacks(dVar);
                post(dVar);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        public final void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onFocusChanged(boolean z2, int i, Rect rect) {
            super.onFocusChanged(z2, i, rect);
            SearchView searchView = this.f925z;
            searchView.w(searchView.l0);
            searchView.post(searchView.f923z0);
            if (searchView.J.hasFocus()) {
                searchView.l();
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f925z.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onWindowFocusChanged(boolean z2) {
            super.onWindowFocusChanged(z2);
            if (z2 && this.f925z.hasFocus() && getVisibility() == 0) {
                this.A = true;
                Context context = getContext();
                i iVar = SearchView.C0;
                if (context.getResources().getConfiguration().orientation == 2) {
                    a();
                }
            }
        }

        public void setImeVisibility(boolean z2) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            d dVar = this.B;
            if (!z2) {
                this.A = false;
                removeCallbacks(dVar);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.A = true;
                    return;
                }
                this.A = false;
                removeCallbacks(dVar);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f925z = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f924y = i;
        }

        @Override // android.widget.AutoCompleteTextView
        public final void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public final void replaceText(CharSequence charSequence) {
        }
    }

    public void setOnCloseListener(u2 u2Var) {
    }

    public void setOnSuggestionListener(w2 w2Var) {
    }
}
