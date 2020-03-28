import subprocess as sb
import os

def find_file(problem):
    for root, dirs, files in os.walk('.'):
        for name in files:
            if problem+'.java' in name:
                return root
    return None

def run_problem(problem, filepath):
    problem_path = ('\\').join([filepath, problem])
    java_path = problem_path + '.java'
    out = sb.run(['javac', java_path])
    if out.returncode == 0:
        print('Running...')
        with open('log.txt', 'w+') as file:
            os.chdir(filepath)
            sb.run(['java', problem], stdout=file, stderr=file)
            os.remove(problem+'.class')
            for _ in range(len(filepath.split('\\'))-1):
                os.chdir('..')
        print('Done!')
    else:
        print('Compilation Error!')

problem = input('What\'s the problem name? ')
filepath = find_file(problem)
if filepath != None:
    print('File found in:',filepath)
    run_problem(problem, filepath)
else:
    division = input('What division? ')
    year = input('What month and year? (MMMYYYY)')

    if os.path.exists('\\'.join([division, year, problem+'.java'])):
        run_problem('\\'.join([division, year, problem+'.java']))
    else:
        print("File does not exist!")
