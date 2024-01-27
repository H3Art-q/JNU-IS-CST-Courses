\PassOptionsToPackage{AutoFakeBold}{xeCJK}
\LoadClass{article}
\usepackage{ctex}
\usepackage{amsmath}
\usepackage{fontspec}
\setmainfont{Times New Roman}

\usepackage{amsmath}
\usepackage{amssymb}
\usepackage{amsfonts}
\usepackage{stackrel}
\usepackage{float}

\usepackage{geometry}
\geometry{left=3.18cm,right=3.18cm,top=4.04cm,bottom=2.54cm,headsep=1cm,headheight=35pt}
\usepackage{fontspec}
\usepackage{makecell}
\usepackage{fancyhdr}
\usepackage{adjustbox}
\usepackage{anyfontsize}
\usepackage{enumerate}

\usepackage[normalem]{ulem}
\useunder{\uline}{\ul}{}

\usepackage{graphicx}
\usepackage{indentfirst}
\setlength{\parindent}{0em} %0em代表首行缩进零个字符

\usepackage{setspace}

% Suppress FandolSong warning
\usepackage{xpatch}
\ExplSyntaxOn
\xpatchcmd \fontspec_new_script:nn
{ \__fontspec_warning:nxx }
{ \__fontspec_info:nxx }
{}{}
% redeclare
\newfontscript{CJK}{hani}
\ExplSyntaxOff

\usepackage{xcolor}
\definecolor{deepblue}{rgb}{0,0,0.5}
\definecolor{deepred}{rgb}{0.6,0,0}
\definecolor{deepgreen}{rgb}{0,0.5,0}

\usepackage{graphics, listings}
\lstset{
    basicstyle=\small\ttfamily,
    keywordstyle=\color{deepblue}\textbf,
    stringstyle=\color{deepred},
    breaklines=true,
    commentstyle=\color{deepgreen},
    numbers=left, numbersep=1em, frame=single
}

\newlength\widest
\makeatletter
\makeatother

\makeatletter

\def\course#1{\gdef\@course{#1}}
\def\@course{\@latex@warning@no@line{No \noexpand\course given}}

\def\expno#1{\gdef\@expno{#1}}
\def\@expno{\@latex@warning@no@line{No \noexpand\expno given}}

\def\exptype#1{\gdef\@exptype{#1}}

\def\authorno#1{\gdef\@authorno{#1}}
\def\@authorno{\@latex@warning@no@line{No \noexpand\authorno given}}

\def\director#1{\gdef\@director{#1}}
\def\@director{\@latex@warning@no@line{No \noexpand\director given}}

\def\classroom#1{\gdef\@classroom{#1}}
\def\@classroom{\@latex@warning@no@line{No \noexpand\classroom given}}

\def\college#1{\gdef\@college{#1}}
\def\@college{\@latex@warning@no@line{No \noexpand\college given}}

\def\department#1{\gdef\@department{#1}}
\def\@department{\@latex@warning@no@line{No \noexpand\department given}}

\def\major#1{\gdef\@major{#1}}
\def\@major{\@latex@warning@no@line{No \noexpand\major given}}

\def\temp#1{\gdef\@temp{#1}}
\def\humid#1{\gdef\@humid{#1}}

% 设置章节编号
\renewcommand\thesection{\arabic{section}.}
\renewcommand\thesubsection{\arabic{subsection}) }
\renewcommand\thesubsubsection{\arabic{subsubsection}.}

% 设置章节编号与章节标题的距离
\makeatletter
\renewcommand\@seccntformat[1]{
    {\csname the#1\endcsname}
}

\makeatother
\pagestyle{fancy}
\fancyhead{}
\fancyhead[C]{{\fontsize{20pt}{\baselineskip}\selectfont \bfseries \kaishu Undergraduate Lab Report of Jinan University}}
\fancyfoot[C]{\thepage}

\makeatletter
\renewcommand\maketitle{
    \begingroup
    \thispagestyle{empty}
    \vspace*{-2cm}
    \begin{center}
        \fontsize{20pt}{\baselineskip}\selectfont \kaishu \bfseries Undergraduate Lab Report of Jinan University
    \end{center}
    \vspace*{-0.3cm}
    \begin{table}[htbp]
        \kaishu
        \fontsize{14pt}{\baselineskip}\selectfont

        \adjustbox{center}{
            \begin{tabular}{l p{6.0cm}<{\centering} l p{3.6cm}}
                Course Title & \@course & Evaluation &
                \\ \cline{2-2} \cline{4-4}
            \end{tabular}
        }

        \adjustbox{center}{
            \begin{tabular}{l p{12.9cm}<{\centering}}
                Lab Name & \@title
                \\ \cline{2-2}
            \end{tabular}
        }

        \adjustbox{center}{
            \begin{tabular}{l p{4.8cm}<{\centering} l p{4.9cm}<{\centering}}
                Lab Address & \@classroom & Instructor & \@director
                \\ \cline{2-2} \cline{4-4}
            \end{tabular}
        }

        \adjustbox{center}{
            \begin{tabular}{l p{4.3cm}<{\centering} l p{4.7cm}<{\centering}}
                Student Name & \@author & Student No. & \@authorno
                \\ \cline{2-2} \cline{4-4}
            \end{tabular}
        }

        \adjustbox{center}{
            \begin{tabular}{l p{13.5cm}<{\centering}}
                College & \@college
                \\ \cline{2-2}
            \end{tabular}
        }

        \adjustbox{center}{
            \begin{tabular}{l p{5.7cm}<{\centering} l p{4.9cm}<{\centering}}
                Department & \@department & Major & \@major
                \\ \cline{2-2} \cline{4-4}
            \end{tabular}
        }

        \adjustbox{center}{
            \begin{tabular}{l p{5cm}<{\centering} l p{8.2cm}}
                Date & \@date & \space &   
                \\ \cline{2-2}
            \end{tabular}
        }

    \end{table}
    \endgroup
}

\makeatother
